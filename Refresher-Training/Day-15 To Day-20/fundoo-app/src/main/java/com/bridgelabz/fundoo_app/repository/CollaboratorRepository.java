package com.bridgelabz.fundoo_app.repository;

import com.bridgelabz.fundoo_app.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {
}
