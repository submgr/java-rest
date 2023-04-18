package ru.itcube46.rest.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @GetMapping(path = "/{event_id}")
    public Iterable<DailyEvents> getAllByEventId(@PathVariable("event_id") Long eventId){
        return dailyEventsRepository.findEventById(eventId);
    }


    @GetMapping
    public Iterable<DailyEvents> list() {
        return dailyEventsRepository.findAll();
    }
    
}

