package ru.itcube46.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.DailyEvents;
import ru.itcube46.rest.entities.Quizzes;
import ru.itcube46.rest.repositories.DailyEventsRepository;
import ru.itcube46.rest.repositories.QuizzesRepository;

/**
 * Контроллеры обрабатывают HTTP-запросы.
 * Зависимости внедряются автоматически через параметры конструктора.
 * Аннотации ...Mapping указывают на методы запроса (GET, POST, и т.д.).
 * Тестировать запросы можно с помощью cURL (см. CURL.md)
 * или других подобных программ.
 */

@RestController
@RequestMapping(path = "/api/admin", produces = "application/json")
public class AdminController {
    private QuizzesRepository quizzesRepository;
    private DailyEventsRepository dailyEventsRepository;

    public AdminController(QuizzesRepository quizzesRepository, DailyEventsRepository dailyEventsRepository) {
        this.quizzesRepository = quizzesRepository;
        this.dailyEventsRepository = dailyEventsRepository;
    }

    //Добавление квиза, если его нет
    @PostMapping(path = "/add-quiz", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Quizzes addQuiz(@RequestBody Quizzes quizzes) {
        return quizzesRepository.save(quizzes);
    }

    //Добавление ивентва, если его нет
    @PostMapping(path = "/add-event", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DailyEvents addEvent(@RequestBody DailyEvents dailyEvents) {
        return dailyEventsRepository.save(dailyEvents);
    }

    @PatchMapping(path = "/update-quiz/{quizzesId}", consumes = "application/json")
    public Quizzes updateQuiz(@PathVariable("quizzesId") Long quizzesId, @RequestBody Quizzes quizzesPatch) {
        Quizzes quizzes = quizzesRepository.findById(quizzesId).get();
        if (quizzesPatch.getDifficulty() != null) {
            quizzes.setDifficulty(quizzesPatch.getDifficulty());
        }
        if (quizzesPatch.getTitle() != null) {
            quizzes.setTitle(quizzesPatch.getTitle());
        }
        if (quizzesPatch.getTheme() != null) {
            quizzes.setTheme(quizzesPatch.getTheme());
        }
        return quizzesRepository.save(quizzes);
    }

    @PatchMapping(path = "/update-event/{eventId}", consumes = "application/json")
    public DailyEvents updateEvent(@PathVariable("eventId") Long eventId, @RequestBody DailyEvents dailyEventsPatch) {
        DailyEvents dailyEvents = dailyEventsRepository.findById(eventId).get();
        if (dailyEventsPatch.getQuizId() != null) {
            dailyEvents.setQuizId(dailyEventsPatch.getQuizId());
        }
        if (dailyEventsPatch.getDifficulty() != null) {
            dailyEvents.setDifficulty(dailyEventsPatch.getDifficulty());
        }
        if (dailyEventsPatch.getEventDate() != null) {
            dailyEvents.setEventDate(dailyEventsPatch.getEventDate());
        }
        if (dailyEventsPatch.getEventName() != null) {
            dailyEvents.setEventName(dailyEventsPatch.getEventName());
        }
        if (dailyEventsPatch.getDailyScores() != null) {
            dailyEvents.setDailyScores(dailyEventsPatch.getDailyScores());
        }
        return dailyEventsRepository.save(dailyEvents);
    }
    
    @DeleteMapping(path = "/delete-quiz/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable("Id") Long Id) {
        quizzesRepository.deleteById(Id);
    }

    @DeleteMapping(path = "/delete-event/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable("Id") Long Id) {
        quizzesRepository.deleteById(Id);
    }
}