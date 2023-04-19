package ru.itcube46.rest.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
    @GetMapping(path = "/dailyEvent")
    public Iterable<DailyEvents> getDailyEvent(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        var thisDay = dateFormat.format(date);
        //System.out.println("**************************************************************************************************************************");
        //System.out.println(thisDay);
        return dailyEventsRepository.findCurrentEvent(thisDay);
    }


    @GetMapping
    public Iterable<DailyEvents> list() {
        return dailyEventsRepository.findAll();
    }
    
}