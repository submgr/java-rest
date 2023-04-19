package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.Quizzes;
import ru.itcube46.rest.repositories.QuizzesRepository;

@RestController
@RequestMapping(path = "api/quizzes", produces = "application/json")
public class QuizzesController {
    private QuizzesRepository quizzesRepository;

    public QuizzesController(QuizzesRepository questionsRepository) {
        this.quizzesRepository = questionsRepository;
    }

    @GetMapping
    public Iterable<Quizzes> list() {
        return quizzesRepository.findAll();
    }

    /* 
    @GetMapping(path = "/{questionId}/{difficulty}")
    public Iterable<Questions> getByQuestionIdAndDifficulty(@PathVariable("questionId") Long questionId ,@PathVariable("difficulty") String difficulty) {
        return questionsRepository.findAllByQuestionIdAndDifficulty(questionId, difficulty);
    }
    */
    @GetMapping(path = "/{difficulty}")
    public Iterable<Quizzes> getByDifficulty(@PathVariable("difficulty") String difficulty) {
        return quizzesRepository.findAllByDifficulty(difficulty);
    }
}