package com.bridgelabz.fundoo_app.controller;

import com.bridgelabz.fundoo_app.dto.NoteRequest;
import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/addNotes")
    public ResponseEntity<Note> addNote(
            @RequestBody NoteRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.addNote(request, principal);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @GetMapping("/getNotesList")
    public ResponseEntity<List<Note>> getNotesList(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.getNotesList(principal);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/getNotesDetail/{noteId}")
    public ResponseEntity<Note> getNoteDetail(
            @PathVariable Integer noteId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.getNoteDetail(noteId, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/updateNotes")
    public ResponseEntity<Note> updateNote(
            @RequestParam Integer noteId,
            @RequestBody NoteRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.updateNote(noteId, request, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/pinUnpinNotes")
    public ResponseEntity<Note> pinUnpinNote(
            @RequestParam Integer noteId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.pinUnpinNote(noteId, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/archiveNotes")
    public ResponseEntity<Note> archiveNote(
            @RequestParam Integer noteId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.archiveNote(noteId, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/trashNotes")
    public ResponseEntity<Note> trashNote(
            @RequestParam Integer noteId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.trashNote(noteId, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/deleteForeverNotes")
    public ResponseEntity<String> deleteForeverNote(
            @RequestParam Integer noteId,
            @AuthenticationPrincipal UserPrincipal principal) {
        noteService.deleteForeverNote(noteId, principal);
        return ResponseEntity.ok("Note deleted forever successfully");
    }

    @GetMapping("/getArchiveNotesList")
    public ResponseEntity<List<Note>> getArchiveNotesList(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.getArchiveNotesList(principal);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/getTrashNotesList")
    public ResponseEntity<List<Note>> getTrashNotesList(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.getTrashNotesList(principal);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("/addUpdateReminderNotes")
    public ResponseEntity<Note> addUpdateReminder(
            @RequestParam Integer noteId,
            @RequestBody List<String> reminders,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.addUpdateReminder(noteId, reminders, principal);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/removeReminderNotes")
    public ResponseEntity<Note> removeReminder(
            @RequestParam Integer noteId,
            @RequestParam String reminder,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteService.removeReminder(noteId, reminder, principal);
        return ResponseEntity.ok(note);
    }

    @GetMapping("/getReminderNotesList")
    public ResponseEntity<List<Note>> getReminderNotesList(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.getReminderNotesList(principal);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(
            @RequestParam(required = false) String titleText,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String labelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.searchNotes(principal, titleText, state, labelName);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/getNotesListByLabel/{labelName}")
    public ResponseEntity<List<Note>> getNotesListByLabel(
            @PathVariable String labelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        List<Note> notes = noteService.getNotesListByLabel(labelName, principal);
        return ResponseEntity.ok(notes);
    }
}
