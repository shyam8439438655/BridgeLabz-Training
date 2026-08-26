package com.bridgelabz.fundoo_app.controller;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.NoteLabel;
import com.bridgelabz.fundoo_app.service.NoteLabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteLabelController {

    private final NoteLabelService noteLabelService;

    public NoteLabelController(NoteLabelService noteLabelService) {
        this.noteLabelService = noteLabelService;
    }

    // UC6: Create label — POST /noteLabels
    @PostMapping("/noteLabels")
    public ResponseEntity<NoteLabel> createLabel(
            @RequestParam String labelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        NoteLabel label = noteLabelService.createLabel(labelName, principal);
        return ResponseEntity.status(HttpStatus.CREATED).body(label);
    }

    // UC6: Update label — PATCH /noteLabels/{id}
    @PatchMapping("/noteLabels/{id}")
    public ResponseEntity<NoteLabel> updateLabel(
            @PathVariable Integer id,
            @RequestParam String newLabelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        NoteLabel label = noteLabelService.updateLabel(id, newLabelName, principal);
        return ResponseEntity.ok(label);
    }

    // UC6: Soft-delete label — DELETE /noteLabels/{id}/deleteNoteLabel
    @DeleteMapping("/noteLabels/{id}/deleteNoteLabel")
    public ResponseEntity<String> deleteLabel(
            @PathVariable Integer id,
            @AuthenticationPrincipal UserPrincipal principal) {
        noteLabelService.deleteLabel(id, principal);
        return ResponseEntity.ok("Label deleted successfully");
    }

    // UC6: Get all active labels — GET /noteLabels/getNoteLabelList
    @GetMapping("/noteLabels/getNoteLabelList")
    public ResponseEntity<List<NoteLabel>> getNoteLabelList(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<NoteLabel> labels = noteLabelService.getNoteLabelList(principal);
        return ResponseEntity.ok(labels);
    }

    // UC6: Add label to note — POST /notes/{noteId}/addLabelToNotes/{labelId}/add
    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/add")
    public ResponseEntity<Note> addLabelToNote(
            @PathVariable Integer noteId,
            @PathVariable Integer labelId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteLabelService.addLabelToNote(noteId, labelId, principal);
        return ResponseEntity.ok(note);
    }

    // UC6: Remove label from note — POST /notes/{noteId}/addLabelToNotes/{labelId}/remove
    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/remove")
    public ResponseEntity<Note> removeLabelFromNote(
            @PathVariable Integer noteId,
            @PathVariable Integer labelId,
            @AuthenticationPrincipal UserPrincipal principal) {
        Note note = noteLabelService.removeLabelFromNote(noteId, labelId, principal);
        return ResponseEntity.ok(note);
    }

    // Backward-compat convenience aliases (keep tests passing)
    @PostMapping("/labels/create")
    public ResponseEntity<NoteLabel> createLabelAlias(
            @RequestParam String labelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        return createLabel(labelName, principal);
    }

    @PostMapping("/labels/update")
    public ResponseEntity<NoteLabel> updateLabelAlias(
            @RequestParam Integer id,
            @RequestParam String newLabelName,
            @AuthenticationPrincipal UserPrincipal principal) {
        return updateLabel(id, newLabelName, principal);
    }

    @PostMapping("/labels/delete")
    public ResponseEntity<String> deleteLabelAlias(
            @RequestParam Integer id,
            @AuthenticationPrincipal UserPrincipal principal) {
        return deleteLabel(id, principal);
    }

    @GetMapping("/labels/list")
    public ResponseEntity<List<NoteLabel>> getLabelListAlias(
            @AuthenticationPrincipal UserPrincipal principal) {
        return getNoteLabelList(principal);
    }

    @PostMapping("/labels/addLabelToNote")
    public ResponseEntity<Note> addLabelAlias(
            @RequestParam Integer noteId,
            @RequestParam Integer labelId,
            @AuthenticationPrincipal UserPrincipal principal) {
        return addLabelToNote(noteId, labelId, principal);
    }

    @PostMapping("/labels/removeLabelFromNote")
    public ResponseEntity<Note> removeLabelAlias(
            @RequestParam Integer noteId,
            @RequestParam Integer labelId,
            @AuthenticationPrincipal UserPrincipal principal) {
        return removeLabelFromNote(noteId, labelId, principal);
    }
}
