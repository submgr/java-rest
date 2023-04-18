package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.DailyEvents;

public interface DailyEventsRepository extends CrudRepository<DailyEvents, Long> {
    @Query("SELECT * FROM DAILY_EVENTS WHERE EVENT_ID = :eid AND EVENT_NAME = :eName")
    Iterable<DailyEvents> findEventByIdAndName(@Param("eid") Long eventId, @Param("eName") String eventName);

    
    @Query("SELECT * FROM DAILY_EVENTS WHERE EVENT_ID = :eid")
    Iterable<DailyEvents> findEventById(@Param("eid") Long eventId);
}