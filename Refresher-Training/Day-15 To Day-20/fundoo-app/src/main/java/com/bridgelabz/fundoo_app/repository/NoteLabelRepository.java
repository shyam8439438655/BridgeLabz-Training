package com.bridgelabz.fundoo_app.repository;

import com.bridgelabz.fundoo_app.entity.NoteLabel;
import com.bridgelabz.fundoo_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {

    // Field is named `deleted` (Lombok generates isDeleted() getter), so Spring Data derives: deleted = false
    List<NoteLabel> findByOwnerAndDeletedFalse(User owner);

    Optional<NoteLabel> findByIdAndOwner(Integer id, User owner);

    Optional<NoteLabel> findByLabelAndOwnerAndDeletedFalse(String label, User owner);
}
