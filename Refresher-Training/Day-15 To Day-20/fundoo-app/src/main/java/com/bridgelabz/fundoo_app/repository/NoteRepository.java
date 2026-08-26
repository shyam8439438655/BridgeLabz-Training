package com.bridgelabz.fundoo_app.repository;

import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {

    List<Note> findByOwnerAndIsArchivedFalseAndIsDeletedFalse(User owner);

    List<Note> findByOwnerAndIsArchivedTrueAndIsDeletedFalse(User owner);

    List<Note> findByOwnerAndIsDeletedTrue(User owner);

    Optional<Note> findByNoteIdAndOwner(Integer noteId, User owner);
}
