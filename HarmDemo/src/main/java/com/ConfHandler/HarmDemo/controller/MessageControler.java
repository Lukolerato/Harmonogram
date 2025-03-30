package com.ConfHandler.HarmDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ConfHandler.HarmDemo.repository.MessageRepository;

@RestController
public class MessageControler {

    @Autowired
    private MessageRepository exampleRepository;

    @GetMapping("/api/message")
    public String getMessage() {
        return exampleRepository.findMessageById();
    }
}
