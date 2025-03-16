package com.ConfHandler.HarmDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ConfHandler.HarmDemo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
