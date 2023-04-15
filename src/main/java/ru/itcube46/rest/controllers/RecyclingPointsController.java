package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.RecyclingPoint;
import ru.itcube46.rest.repositories.RecyclingPointsRepository;

@RestController
@RequestMapping(path = "/api/points", produces = "application/json")
public class RecyclingPointsController {
    private RecyclingPointsRepository pointRepository;

    public RecyclingPointsController(RecyclingPointsRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("/city/{city}")
    public Iterable<RecyclingPoint> getPointByCity(@PathVariable String city) {
        return pointRepository.findAllByCity(city);
    }

    @PostMapping("/add")
    public RecyclingPoint addPoint(@RequestBody RecyclingPoint point) {
        return pointRepository.save(point);
    }
}
