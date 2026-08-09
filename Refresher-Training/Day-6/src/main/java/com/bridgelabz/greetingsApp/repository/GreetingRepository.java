package com.bridgelabz.greetingsApp.repository;

import com.bridgelabz.greetingsApp.entity.GreetingApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingApp,Long> {

}
