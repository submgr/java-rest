package ru.itcube46.rest.controllers;

import org.springframework.security.access.method.P;
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

    @GetMapping(path = "/scores/{quizId}")
    public Iterable<Questions> getScoreByQuizId(@PathVariable("quizId") Long quizId) {
        return questionsRepository.findScoresByQuizId(quizId);
    }

    @GetMapping(path = "/{quizId}")
    public Iterable<Questions> getQuestionsByQuizId(@PathVariable("quizId") Long quizId) {
        return questionsRepository.findQuestionsByQuizId(quizId);
    }

    @GetMapping(path = "/checkAnswer/{questionId}/{answer}")
    public boolean getQuestionAnswer(@PathVariable("questionId") Long questionId,
            @PathVariable("answer") String answer) {
        String correctAnswer = questionsRepository.findAnswersByQuestion(questionId);
        return (correctAnswer.equals(answer));
    }

}