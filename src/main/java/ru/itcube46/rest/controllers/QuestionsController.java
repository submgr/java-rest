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
    @GetMapping(path = "/{id}")
    public Iterable<Questions> getDoubleSumOfScores(@PathVariable("id") Long questionId) {
        return questionsRepository.doubleSumQuestionsScores(questionId);
    }
}
