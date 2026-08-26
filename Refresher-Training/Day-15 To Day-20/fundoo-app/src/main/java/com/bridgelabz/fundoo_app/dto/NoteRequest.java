package com.bridgelabz.fundoo_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {
    private String title;
    private String description;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;
}
