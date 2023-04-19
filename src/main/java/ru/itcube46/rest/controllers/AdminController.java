package ru.itcube46.rest.controllers;

import org.springframework.http.HttpStatus;
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

import ru.itcube46.rest.entities.User;
import ru.itcube46.rest.repositories.DailyEventsRepository;
import ru.itcube46.rest.repositories.QuestionsRepository;
import ru.itcube46.rest.repositories.QuizzesRepository;
import ru.itcube46.rest.repositories.UsersRepository;

/**
 * Контроллеры обрабатывают HTTP-запросы.
 * Зависимости внедряются автоматически через параметры конструктора.
 * Аннотации ...Mapping указывают на методы запроса (GET, POST, и т.д.).
 * Тестировать запросы можно с помощью cURL (см. CURL.md)
 * или других подобных программ.
 */
/* 
@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
public class AdminController {
    private QuizzesRepository quizzesRepository;
    private DailyEventsRepository dailyEventsRepository;
    private QuestionsRepository questionsRepository;

    public AdminController() {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{email}")
    public User getByEmail(@PathVariable("email") String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
*/
