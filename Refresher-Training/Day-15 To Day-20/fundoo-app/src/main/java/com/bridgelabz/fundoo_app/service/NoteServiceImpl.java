package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.exception.ResourceNotFoundException;
import com.bridgelabz.fundoo_app.dto.NoteRequest;
import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.User;
import com.bridgelabz.fundoo_app.repository.NoteRepository;
import com.bridgelabz.fundoo_app.repository.UserRepository;
import com.bridgelabz.fundoo_app.repository.NoteSpecification;
import com.bridgelabz.fundoo_app.messaging.rabbitmq.RabbitMQProducer;
import com.bridgelabz.fundoo_app.messaging.jms.ReminderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired(required = false)
    private ReminderProducer reminderProducer;

    @Autowired(required = false)
    private RabbitMQProducer rabbitMQProducer;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    private User getUser(UserPrincipal principal) {
        return userRepository.findByEmail(principal.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    private Note getAndVerifyNote(Integer noteId, User owner) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getOwner().getUserId().equals(owner.getUserId())) {
            throw new ResourceNotFoundException("Note not found"); // information-leak reasoning
        }
        return note;
    }

    private void evictCache(User owner) {
        if (redisTemplate != null) {
            String cacheKey = "notes:list:" + owner.getUserId();
            try {
                redisTemplate.delete(cacheKey);
                log.info("Evicted notes list cache for user ID: " + owner.getUserId());
            } catch (Exception e) {
                log.warn("Redis delete cache failed: " + e.getMessage());
            }
        }
    }

    @Override
    public Note addNote(NoteRequest request, UserPrincipal principal) {
        User owner = getUser(principal);

        Note note = Note.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .color(request.getColor())
                .typeOfNote(request.getTypeOfNote() != null ? request.getTypeOfNote() : "TEXT")
                .imageUrl(request.getImageUrl())
                .linkUrl(request.getLinkUrl())
                .owner(owner)
                .build();

        Note savedNote = noteRepository.save(note);
        evictCache(owner);
        return savedNote;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> getNotesList(UserPrincipal principal) {
        User owner = getUser(principal);
        String cacheKey = "notes:list:" + owner.getUserId();

        // Try fetching from Redis cache (Use Case 9 extension)
        if (redisTemplate != null) {
            try {
                List<Note> cachedNotes = (List<Note>) redisTemplate.opsForValue().get(cacheKey);
                if (cachedNotes != null) {
                    log.info("Redis HIT: Retrieved notes list from cache for user ID: " + owner.getUserId());
                    return cachedNotes;
                }
            } catch (Exception e) {
                log.warn("Redis fetch cache failed: " + e.getMessage());
            }
        }

        log.info("Redis MISS: Fetching notes list from database for user ID: " + owner.getUserId());
        List<Note> notes = noteRepository.findByOwnerAndIsArchivedFalseAndIsDeletedFalse(owner);

        if (redisTemplate != null && !notes.isEmpty()) {
            try {
                redisTemplate.opsForValue().set(cacheKey, notes, Duration.ofSeconds(10)); // 10s TTL
                log.info("Cached notes list in Redis for user ID: " + owner.getUserId());
            } catch (Exception e) {
                log.warn("Redis write cache failed: " + e.getMessage());
            }
        }

        return notes;
    }

    @Override
    public Note getNoteDetail(Integer noteId, UserPrincipal principal) {
        User owner = getUser(principal);
        return getAndVerifyNote(noteId, owner);
    }

    @Override
    public Note updateNote(Integer noteId, NoteRequest request, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        if (request.getTitle() != null) note.setTitle(request.getTitle());
        if (request.getDescription() != null) note.setDescription(request.getDescription());
        if (request.getColor() != null) note.setColor(request.getColor());
        if (request.getTypeOfNote() != null) note.setTypeOfNote(request.getTypeOfNote());
        if (request.getImageUrl() != null) note.setImageUrl(request.getImageUrl());
        if (request.getLinkUrl() != null) note.setLinkUrl(request.getLinkUrl());

        Note updatedNote = noteRepository.save(note);
        evictCache(owner);
        return updatedNote;
    }

    @Override
    public Note pinUnpinNote(Integer noteId, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        // Rule: cannot pin a trashed note
        if (note.isDeleted()) {
            throw new IllegalStateException("Cannot pin a trashed note");
        }

        note.setPined(!note.isPined());
        Note updatedNote = noteRepository.save(note);
        evictCache(owner);
        return updatedNote;
    }

    @Override
    public Note archiveNote(Integer noteId, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        note.setArchived(!note.isArchived());
        // Archiving automatically unpins
        if (note.isArchived()) {
            note.setPined(false);
        }

        Note updatedNote = noteRepository.save(note);
        evictCache(owner);
        return updatedNote;
    }

    @Override
    public Note trashNote(Integer noteId, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        note.setDeleted(true);
        // Trashing automatically unpins
        note.setPined(false);

        Note updatedNote = noteRepository.save(note);
        evictCache(owner);
        return updatedNote;
    }

    @Override
    public void deleteForeverNote(Integer noteId, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        noteRepository.delete(note);
        evictCache(owner);

        // Use Case 10: Fanout Event deletion
        if (rabbitMQProducer != null) {
            rabbitMQProducer.sendDeleteEvent("Note with ID " + noteId + " deleted forever");
            log.info("Fired RabbitMQ Delete Fanout Event for note ID: " + noteId);
        }
    }

    @Override
    public List<Note> getArchiveNotesList(UserPrincipal principal) {
        User owner = getUser(principal);
        return noteRepository.findByOwnerAndIsArchivedTrueAndIsDeletedFalse(owner);
    }

    @Override
    public List<Note> getTrashNotesList(UserPrincipal principal) {
        User owner = getUser(principal);
        return noteRepository.findByOwnerAndIsDeletedTrue(owner);
    }

    @Override
    public Note addUpdateReminder(Integer noteId, List<String> reminders, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        List<LocalDateTime> parsedReminders = reminders.stream()
                .map(r -> LocalDateTime.parse(r, formatter))
                .collect(Collectors.toList());

        note.setReminders(parsedReminders);
        Note savedNote = noteRepository.save(note);
        evictCache(owner);

        // Fire JMS message for each reminder
        if (reminderProducer != null) {
            for (String reminder : reminders) {
                reminderProducer.sendReminder("Note '" + note.getTitle() + "' reminder set for " + reminder);
                log.info("Fired JMS reminder event for note ID: " + noteId + " at " + reminder);
            }
        }

        return savedNote;
    }

    @Override
    public Note removeReminder(Integer noteId, String reminder, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        LocalDateTime parsed = LocalDateTime.parse(reminder, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        note.getReminders().remove(parsed);

        Note savedNote = noteRepository.save(note);
        evictCache(owner);
        return savedNote;
    }

    @Override
    public List<Note> getReminderNotesList(UserPrincipal principal) {
        User owner = getUser(principal);
        return noteRepository.findByOwnerAndIsArchivedFalseAndIsDeletedFalse(owner)
                .stream()
                .filter(n -> !n.getReminders().isEmpty())
                .collect(Collectors.toList());
    }

    @Override
    public Note shareNote(Integer noteId, String collaboratorEmail, UserPrincipal principal) {
        User owner = getUser(principal);
        Note note = getAndVerifyNote(noteId, owner);

        User collaborator = userRepository.findByEmail(collaboratorEmail)
                .orElseThrow(() -> new IllegalArgumentException("Collaborator email not found"));

        note.getCollaborators().add(collaborator);
        Note savedNote = noteRepository.save(note);
        evictCache(owner);

        // Use Case 10: RabbitMQ shared event
        if (rabbitMQProducer != null) {
            String message = "Note '" + note.getTitle() + "' (ID: " + noteId + ") shared by " + owner.getEmail() + " with " + collaboratorEmail;
            rabbitMQProducer.sendShareEvent(message);
            log.info("Fired RabbitMQ shared event for note ID: " + noteId);
        }

        return savedNote;
    }

    @Override
    public List<Note> searchNotes(UserPrincipal principal, String titleText, String state, String labelName) {
        User owner = getUser(principal);
        return noteRepository.findAll(NoteSpecification.search(owner, titleText, state, labelName));
    }

    @Override
    public List<Note> getNotesListByLabel(String labelName, UserPrincipal principal) {
        User owner = getUser(principal);
        return noteRepository.findAll(NoteSpecification.search(owner, null, null, labelName));
    }
}
