package com.example.rest.repository;

import com.example.rest.entities.Task;

public interface TaskRepository {
    Iterable<Task> findAllByUserId(int userId);

    Task save(Task task);
}
