package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.DailyEvents;

public interface DailyEventsRepository extends CrudRepository<DailyEvents, Long> {
    @Query("SELECT * FROM DAILY_EVENTS WHERE QUIZ_ID = :qid AND EVENT_NAME = :eName")
    Iterable<DailyEvents> findEventByIdAndName(@Param("qid") Long quizId, @Param("eName") String eventName);

    
    @Query("SELECT * FROM DAILY_EVENTS WHERE DAILY_SCORES = :dailyScores")
    Iterable<DailyEvents> findEventByDailyScores(@Param("dailyScores") Long dailyScores);// сменил qid на eid   
}