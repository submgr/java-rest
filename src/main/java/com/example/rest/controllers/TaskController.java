package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entities.Task;
import com.example.rest.repository.TaskRepository;

@RestController
@RequestMapping(path = "/tasks", produces = "application/json")
public class TaskController {
    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/userTasks/{userId}")
    public Iterable<Task> getUserTasks(@PathVariable int userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // curl --header "Content-Type: application/json" \
    // --request POST \
    // --data '{"userId":"1","title":"test", "description":"test descr", "dateOfCreation":"2022-10-10", "dateOfCompletion":"2022-10-10"}' \
    // http:// localhost:8080/tasks/addTask
}
