package com.contactApp.contactApp.repository;

import com.contactApp.contactApp.DTO.ResponseDTO;
import com.contactApp.contactApp.entity.ContactApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactAppRepository extends JpaRepository<ContactApp, Integer> {

    List<ContactApp> findByNameContaining(String  name);
    Optional<ContactApp> findByMobNo(String mobNo);
}