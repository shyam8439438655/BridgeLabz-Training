package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.exception.ResourceNotFoundException;
import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.NoteLabel;
import com.bridgelabz.fundoo_app.entity.User;
import com.bridgelabz.fundoo_app.repository.NoteLabelRepository;
import com.bridgelabz.fundoo_app.repository.NoteRepository;
import com.bridgelabz.fundoo_app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NoteLabelServiceImpl implements NoteLabelService {

    private final NoteLabelRepository noteLabelRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteLabelServiceImpl(NoteLabelRepository noteLabelRepository,
                                NoteRepository noteRepository,
                                UserRepository userRepository) {
        this.noteLabelRepository = noteLabelRepository;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    private User getUser(UserPrincipal principal) {
        return userRepository.findByEmail(principal.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public NoteLabel createLabel(String labelName, UserPrincipal principal) {
        User owner = getUser(principal);

        // Enforce label uniqueness per user in Service Layer
        Optional<NoteLabel> existing = noteLabelRepository.findByLabelAndOwnerAndDeletedFalse(labelName, owner);
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Label with name '" + labelName + "' already exists for this user.");
        }

        // If a soft-deleted label exists, reactivate it
        Optional<NoteLabel> deletedOpt = noteLabelRepository.findAll().stream()
                .filter(l -> l.getLabel().equalsIgnoreCase(labelName)
                        && l.getOwner().getUserId().equals(owner.getUserId())
                        && l.isDeleted())
                .findFirst();

        if (deletedOpt.isPresent()) {
            NoteLabel label = deletedOpt.get();
            label.setDeleted(false);
            return noteLabelRepository.save(label);
        }

        NoteLabel label = NoteLabel.builder()
                .label(labelName)
                .owner(owner)
                .build();

        return noteLabelRepository.save(label);
    }

    @Override
    public NoteLabel updateLabel(Integer id, String newLabelName, UserPrincipal principal) {
        User owner = getUser(principal);
        NoteLabel label = noteLabelRepository.findByIdAndOwner(id, owner)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        if (label.isDeleted()) {
            throw new IllegalArgumentException("Cannot update a deleted label");
        }

        Optional<NoteLabel> existing = noteLabelRepository.findByLabelAndOwnerAndDeletedFalse(newLabelName, owner);
        if (existing.isPresent() && !existing.get().getId().equals(id)) {
            throw new IllegalArgumentException("Label with name '" + newLabelName + "' already exists for this user.");
        }

        label.setLabel(newLabelName);
        return noteLabelRepository.save(label);
    }

    @Override
    public void deleteLabel(Integer id, UserPrincipal principal) {
        User owner = getUser(principal);
        NoteLabel label = noteLabelRepository.findByIdAndOwner(id, owner)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        // Soft-delete label (Use Case 6 spec)
        label.setDeleted(true);
        noteLabelRepository.save(label);
    }

    @Override
    public List<NoteLabel> getNoteLabelList(UserPrincipal principal) {
        User owner = getUser(principal);
        return noteLabelRepository.findByOwnerAndDeletedFalse(owner);
    }

    @Override
    public Note addLabelToNote(Integer noteId, Integer labelId, UserPrincipal principal) {
        User owner = getUser(principal);

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        NoteLabel label = noteLabelRepository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        // Ownership verification (information leak reasoning)
        if (!note.getOwner().getUserId().equals(owner.getUserId()) ||
                !label.getOwner().getUserId().equals(owner.getUserId()) ||
                label.isDeleted()) {
            throw new ResourceNotFoundException("Note or Label not found");
        }

        note.getLabels().add(label);
        return noteRepository.save(note);
    }

    @Override
    public Note removeLabelFromNote(Integer noteId, Integer labelId, UserPrincipal principal) {
        User owner = getUser(principal);

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        NoteLabel label = noteLabelRepository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        if (!note.getOwner().getUserId().equals(owner.getUserId()) ||
                !label.getOwner().getUserId().equals(owner.getUserId())) {
            throw new ResourceNotFoundException("Note or Label not found");
        }

        note.getLabels().remove(label);
        return noteRepository.save(note);
    }
}
