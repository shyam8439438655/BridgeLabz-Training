package com.contactApp.contactApp.repository;

import com.contactApp.contactApp.entity.ContactApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAppRepository extends JpaRepository<ContactApp,Integer> {


}
