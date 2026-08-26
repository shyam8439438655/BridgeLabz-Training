package com.bridgelabz.fundoo_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteShareMessage {
    private Integer noteId;
    private String senderEmail;
    private String receiverEmail;
    private String message;
}
