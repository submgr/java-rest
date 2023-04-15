package ru.itcube46.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.User;
import ru.itcube46.rest.repositories.UsersRepository;

@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
public class UsersController {
    private UsersRepository userRepository;

    public UsersController(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    // curl -X GET http://localhost:8080/api/users

    @GetMapping(path = "/login/{email}/{password}")
    public User login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }
    // curl -X GET http://localhost:8080/api/users/login/admin@itcube46.ru/qwe

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User registration(@RequestBody User user) {
        return userRepository.save(user);
    }
    // curl -H "Content-Type: application/json" -X POST -d \
    // '{"email":"adm1n@itcube46.ru","password":"qwe","username":"Adm1n","age":0}' \
    // http://127.0.0.1:8080/api/users/add

    @PatchMapping(path = "/patch/{id}", consumes = "application/json")
    public User patchUser(@PathVariable("id") Long userId, @RequestBody User userPatch) {
        User user = userRepository.findById(userId).get();
        if (userPatch.getEmail() != null) {
            user.setEmail(userPatch.getEmail());
        }
        if (userPatch.getPassword() != null) {
            user.setPassword(userPatch.getPassword());
        }
        if (userPatch.getUsername() != null) {
            user.setUsername(userPatch.getUsername());
        }
        if (userPatch.getAge() != null) {
            user.setAge(userPatch.getAge());
        }
        return userRepository.save(user);
    }
    // curl -H "Content-Type: application/json" -X PATCH -d \
    // '{"email":"adm1n@itcube46.ru","password":"asd","username":"Adm1n","age":0}' \
    // http://127.0.0.1:8080/api/users/patch/66

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long userId) {
        userRepository.deleteById(userId);
    }
    // curl -X DELETE http://127.0.0.1:8080/api/users/delete/66
}
