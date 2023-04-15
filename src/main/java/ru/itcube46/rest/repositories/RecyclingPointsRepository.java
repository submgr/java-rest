package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.RecyclingPoint;

public interface RecyclingPointsRepository extends CrudRepository<RecyclingPoint, Long> {
    @Query("SELECT * FROM RECYCLING_POINTS WHERE CITY = :city")
    Iterable<RecyclingPoint> findAllByCity(@Param("city") String city);
}
