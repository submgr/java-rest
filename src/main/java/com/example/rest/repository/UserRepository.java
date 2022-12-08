package com.example.rest.repository;

import java.util.Optional;

import com.example.rest.entities.User;

public interface UserRepository {
    Optional<User> findByNameAndPassword(String name, String password);

    User save(User user);
}
