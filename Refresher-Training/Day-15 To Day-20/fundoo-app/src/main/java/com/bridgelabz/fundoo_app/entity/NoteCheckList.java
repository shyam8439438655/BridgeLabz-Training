package com.bridgelabz.fundoo_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note_checklists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteCheckList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String itemName;

    private String status;

    @Builder.Default
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
}