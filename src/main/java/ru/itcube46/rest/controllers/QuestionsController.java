package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.Questions;
import ru.itcube46.rest.repositories.QuestionsRepository;

@RestController
@RequestMapping(path = "api/questions", produces = "application/json")
public class QuestionsController {
    private QuestionsRepository questionsRepository;

    public QuestionsController(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @GetMapping
    public Iterable<Questions> list() {
        return questionsRepository.findAll();
    }

    /* 
    @GetMapping(path = "/{questionId}/{difficulty}")
    public Iterable<Questions> getByQuestionIdAndDifficulty(@PathVariable("questionId") Long questionId ,@PathVariable("difficulty") String difficulty) {
        return questionsRepository.findAllByQuestionIdAndDifficulty(questionId, difficulty);
    }
    */
    @GetMapping(path = "/{difficulty}")
    public Iterable<Questions> getByDifficulty(@PathVariable("difficulty") String difficulty) {
        return questionsRepository.findAllByDifficulty(difficulty);
    }
}