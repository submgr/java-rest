package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.DailyEvents;
import ru.itcube46.rest.repositories.DailyEventsRepository;

@RestController
@RequestMapping(path = "api/events", produces = "application/json")
public class DailyEventsController {
    private DailyEventsRepository dailyEventsRepository;
    

    public DailyEventsController(DailyEventsRepository dailyEventsRepository){
        this.dailyEventsRepository = dailyEventsRepository;
    }
    
    @GetMapping(path = "/{dailyScores}")
    public Iterable<DailyEvents> getAllByScores(@PathVariable("dailyScores") Long dailyScores){
        return dailyEventsRepository.findEventByDailyScores(dailyScores);
    }


    @GetMapping
    public Iterable<DailyEvents> list() {
        return dailyEventsRepository.findAll();
    }
    
}