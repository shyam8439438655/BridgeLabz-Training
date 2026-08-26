package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.User;
import com.bridgelabz.fundoo_app.entity.Collaborator;
import com.bridgelabz.fundoo_app.repository.CollaboratorRepository;
import com.bridgelabz.fundoo_app.repository.UserRepository;
import com.bridgelabz.fundoo_app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private final NoteService noteService;
    private final CollaboratorRepository collaboratorRepository;
    private final UserRepository userRepository;

    public CollaboratorServiceImpl(NoteService noteService,
                                   CollaboratorRepository collaboratorRepository,
                                   UserRepository userRepository) {
        this.noteService = noteService;
        this.collaboratorRepository = collaboratorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Note shareNote(Integer noteId, String collaboratorEmail, UserPrincipal principal) {
        Note note = noteService.shareNote(noteId, collaboratorEmail, principal);
        
        User collaboratorUser = userRepository.findByEmail(collaboratorEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                
        // Also save in collaborator repository for completeness
        Collaborator collaborator = Collaborator.builder()
                .note(note)
                .user(collaboratorUser)
                .build();
        collaboratorRepository.save(collaborator);
        
        return note;
    }
}
