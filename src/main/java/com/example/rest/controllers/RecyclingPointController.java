package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entities.RecyclingPoint;
import com.example.rest.repository.RecyclingPointRepository;

@RestController
@RequestMapping(path = "/points", produces = "application/json")
public class RecyclingPointController {
    private RecyclingPointRepository pointRepository;

    @Autowired
    public RecyclingPointController(RecyclingPointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("/city/{city}")
    public Iterable<RecyclingPoint> getUserTasks(@PathVariable String city) {
        return pointRepository.findAllByCity(city);
    }

    @PostMapping("/add-point")
    public RecyclingPoint addTask(@RequestBody RecyclingPoint point) {
        return pointRepository.save(point);
    }

    // curl --header "Content-Type: application/json" \
    // --request POST \
    // --data '{"city":"Курск", "latitude":"0.0", "longitude":"0.0"}' \
    // http:// localhost:8080/tasks/add-point
}
