package ru.itcube46.rest.controllers;

import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import ru.itcube46.rest.entities.User;
import ru.itcube46.rest.repositories.UsersRepository;

/**
 * Контроллеры обрабатывают HTTP-запросы.
 * Зависимости внедряются автоматически через параметры конструктора.
 * Аннотации ...Mapping указывают на методы запроса (GET, POST, и т.д.).
 * Тестировать запросы можно с помощью cURL (см. CURL.md)
 * или других подобных программ.
 */
@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
public class UsersController {
    private UsersRepository userRepository;
    private PasswordEncoder encoder;

    public UsersController(UsersRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable ("id") Long uid){
 
        return userRepository.findByUserId(uid);
    }


    @GetMapping(path = "/email/{email}")
    public User getByEmail(@PathVariable("email") String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @GetMapping(path = "/{userName}")
    public User getByUserName(@PathVariable("userName") String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


    


    @PostMapping(path = "/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = encoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @PostMapping(path = "/{id}/plusscores/{scores}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User plusScores(@PathVariable("id") Long userId, @PathVariable("scores") Integer scores) {
            User user = userRepository.findById(userId).get();
            Integer pscore =  user.getScores() +scores;
            user.setScores(pscore);
            return userRepository.save(user);
    }
   
    
    // @PostMapping(path = "/{userName}/addByName")
    // @ResponseStatus(HttpStatus.CREATED)
    // public User addUserName(@PathVariable("userName") String name) {
    //     String user = userRepository.findUserByName(name);
    //     if user.get
    //     return null;

        
    // }

    // @PatchMapping(path = "{id}/plusscores/{scores}", consumes = "application/json")
    // public User plusScores(@PathVariable("id") Long userId, @PathVariable("scores") Integer scores, @RequestBody User userPatch) {
    //       User user = userRepository.findById(userId).get(); 
    //       Integer pscore = userPatch.getScores() + scores;
    //       user.setScores(pscore);
    //       return userRepository.save(user);

    // }

    @PostMapping(path = "/{id}/plusdoublescores/{scores}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User plusdoublescores(@PathVariable("id") Long userId, @PathVariable("scores") Integer scores) {
            User user = userRepository.findById(userId).get();
            Integer pscore =  user.getScores() +scores*2;
            user.setScores(pscore);
            return userRepository.save(user);
    }

    @PatchMapping(path = "/update/{id}", consumes = "application/json")
    public User update(@PathVariable("id") Long userId, @RequestBody User userPatch) {
        User user = userRepository.findById(userId).get();
        if (userPatch.getEmail() != null) {
            user.setEmail(userPatch.getEmail());
        }
        if (userPatch.getPassword() != null) {
            String rawPassword = userPatch.getPassword();
            String encodedPassword = encoder.encode(rawPassword);
            user.setPassword(encodedPassword);
        }
        if (userPatch.getUsername() != null) {
            user.setUsername(userPatch.getUsername());
        }
        if (userPatch.getAge() != null) {
            user.setAge(userPatch.getAge());
        }
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long userId) {
        userRepository.deleteById(userId);
    }
}