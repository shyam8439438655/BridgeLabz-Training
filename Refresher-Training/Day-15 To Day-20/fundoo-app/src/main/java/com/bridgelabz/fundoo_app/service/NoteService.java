package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.NoteRequest;
import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;

import java.util.List;

public interface NoteService {

    Note addNote(NoteRequest request, UserPrincipal principal);

    List<Note> getNotesList(UserPrincipal principal);

    Note getNoteDetail(Integer noteId, UserPrincipal principal);

    Note updateNote(Integer noteId, NoteRequest request, UserPrincipal principal);

    Note pinUnpinNote(Integer noteId, UserPrincipal principal);

    Note archiveNote(Integer noteId, UserPrincipal principal);

    Note trashNote(Integer noteId, UserPrincipal principal);

    void deleteForeverNote(Integer noteId, UserPrincipal principal);

    List<Note> getArchiveNotesList(UserPrincipal principal);

    List<Note> getTrashNotesList(UserPrincipal principal);

    Note addUpdateReminder(Integer noteId, List<String> reminders, UserPrincipal principal);

    Note removeReminder(Integer noteId, String reminder, UserPrincipal principal);

    List<Note> getReminderNotesList(UserPrincipal principal);

    Note shareNote(Integer noteId, String collaboratorEmail, UserPrincipal principal);

    List<Note> searchNotes(UserPrincipal principal, String titleText, String state, String labelName);

    List<Note> getNotesListByLabel(String labelName, UserPrincipal principal);
}
