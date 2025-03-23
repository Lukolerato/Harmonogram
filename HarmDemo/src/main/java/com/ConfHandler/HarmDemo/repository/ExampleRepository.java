package com.ConfHandler.HarmDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ConfHandler.HarmDemo.model.Message;

@Repository
public interface ExampleRepository extends JpaRepository<Message, Long> {
    
    @Query("SELECT m.message FROM Message m WHERE m.id = 1")
    String findMessageById();
    
}
