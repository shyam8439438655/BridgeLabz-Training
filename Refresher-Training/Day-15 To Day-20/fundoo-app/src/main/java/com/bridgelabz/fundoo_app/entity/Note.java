package com.bridgelabz.fundoo_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer noteId;


    @Column(name = "title")
    private String title;


    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @Builder.Default
    @Column(name = "pinned", nullable = false)
    private boolean isPined = false;


    @Builder.Default
    @Column(name = "archived", nullable = false)
    private boolean isArchived = false;


    @Builder.Default
    @Column(name = "trashed", nullable = false)
    private boolean isDeleted = false;


    @Column(name = "color")
    private String color;


    @Column(name = "type_of_note")
    private String typeOfNote;


    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "link_url")
    private String linkUrl;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "note_note_labels",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    @Builder.Default
    private Set<NoteLabel> labels = new HashSet<>();


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "note_reminders",
            joinColumns = @JoinColumn(name = "note_id")
    )
    @Column(name = "reminder_time")
    @Builder.Default
    private List<LocalDateTime> reminders = new ArrayList<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "note_collaborators",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Builder.Default
    private Set<User> collaborators = new HashSet<>();


    @OneToMany(
            mappedBy = "note",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<NoteCheckList> checkLists = new ArrayList<>();


    // Getter Setter for ServiceImpl

    public boolean isPined() {
        return isPined;
    }

    public void setPined(boolean pined) {
        this.isPined = pined;
    }


    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        this.isArchived = archived;
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }


    // Lombok Builder fix for Test cases

    public static class NoteBuilder {

        private boolean isPined;
        private boolean isArchived;
        private boolean isDeleted;


        public NoteBuilder isPined(boolean value) {
            this.isPined = value;
            return this;
        }


        public NoteBuilder isArchived(boolean value) {
            this.isArchived = value;
            return this;
        }


        public NoteBuilder isDeleted(boolean value) {
            this.isDeleted = value;
            return this;
        }
    }
}