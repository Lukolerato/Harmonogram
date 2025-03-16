package com.ConfHandler.HarmDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ConfHandler.HarmDemo.model.Task;
import com.ConfHandler.HarmDemo.repository.TaskRepository;

@CrossOrigin(origins = "http://localhost:3000") // Zezwala na zapytania z React
@RestController
@RequestMapping("/api/test")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
