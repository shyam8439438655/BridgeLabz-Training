package com.bridgelabz.fundoo_app.service;

import com.bridgelabz.fundoo_app.dto.UserPrincipal;
import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.NoteLabel;

import java.util.List;

public interface NoteLabelService {

    NoteLabel createLabel(String labelName, UserPrincipal principal);

    NoteLabel updateLabel(Integer id, String newLabelName, UserPrincipal principal);

    void deleteLabel(Integer id, UserPrincipal principal);

    List<NoteLabel> getNoteLabelList(UserPrincipal principal);

    Note addLabelToNote(Integer noteId, Integer labelId, UserPrincipal principal);

    Note removeLabelFromNote(Integer noteId, Integer labelId, UserPrincipal principal);
}
