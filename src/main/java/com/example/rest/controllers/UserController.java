package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entities.User;
import com.example.rest.repository.UserRepository;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login/{name}/{password}")
    public User getUser(@PathVariable String name, @PathVariable String password) {
        User user = userRepository.findByNameAndPassword(name, password).orElse(null);
        return user;
    }

    @PostMapping("/add-user")
    public User addTask(@RequestBody User user) {
        return userRepository.save(user);
    }

    // curl --header "Content-Type: application/json" \
    // --request POST \
    // --data '{"name":"Вася","password":"789"}' \
    // http://localhost:8080/users/add-user
}
