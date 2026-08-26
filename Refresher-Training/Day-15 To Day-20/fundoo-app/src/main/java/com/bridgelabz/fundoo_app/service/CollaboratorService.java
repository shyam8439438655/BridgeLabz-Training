package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;

public interface CollaboratorService {
    Note shareNote(Integer noteId, String collaboratorEmail, UserPrincipal principal);
}
