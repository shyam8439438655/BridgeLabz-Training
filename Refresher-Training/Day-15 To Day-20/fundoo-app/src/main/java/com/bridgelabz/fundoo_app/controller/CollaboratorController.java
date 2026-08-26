package com.bridgelabz.fundoo_app.controller;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.service.CollaboratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping("/{noteId}/share")
    public ResponseEntity<Note> shareNote(
            @PathVariable Integer noteId,
            @RequestParam String collaboratorEmail,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = collaboratorService.shareNote(noteId, collaboratorEmail, principal);
        return ResponseEntity.ok(note);
    }
}
