package com.bridgelabz.fundoo_app.repository;

import com.bridgelabz.fundoo_app.entity.Note;
import com.bridgelabz.fundoo_app.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteSpecification {

    public static Specification<Note> search(User owner, String titleText, String state, String labelName) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. Owner predicate: ALWAYS unconditional
            predicates.add(cb.equal(root.get("owner"), owner));

            // 2. Title filter
            if (titleText != null && !titleText.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + titleText.toLowerCase() + "%"));
            }

            // 3. State filter
            if (state != null && !state.trim().isEmpty()) {
                switch (state.toLowerCase()) {
                    case "pinned":
                        predicates.add(cb.equal(root.get("isPined"), true));
                        predicates.add(cb.equal(root.get("isDeleted"), false));
                        predicates.add(cb.equal(root.get("isArchived"), false));
                        break;
                    case "archived":
                        predicates.add(cb.equal(root.get("isArchived"), true));
                        predicates.add(cb.equal(root.get("isDeleted"), false));
                        break;
                    case "trashed":
                        predicates.add(cb.equal(root.get("isDeleted"), true));
                        break;
                    default:
                        predicates.add(cb.equal(root.get("isDeleted"), false));
                        predicates.add(cb.equal(root.get("isArchived"), false));
                        break;
                }
            } else {
                predicates.add(cb.equal(root.get("isDeleted"), false));
            }

            // 4. Label filter
            if (labelName != null && !labelName.trim().isEmpty()) {
                predicates.add(cb.equal(root.join("labels").get("label"), labelName));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
