package com.example.rest.repository;

import com.example.rest.entities.RecyclingPoint;

public interface RecyclingPointRepository {
    Iterable<RecyclingPoint> findAllByCity(String city);

    RecyclingPoint save(RecyclingPoint point);
}
