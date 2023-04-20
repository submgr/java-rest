package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.LearningVideos;
import ru.itcube46.rest.repositories.LearningVideosRepository;

@RestController
@RequestMapping(path = "api/videos", produces = "application/json")
public class LearningVideosController {
    private LearningVideosRepository learningVideosRepository;

    public LearningVideosController(LearningVideosRepository learningVideosRepository) {
        this.learningVideosRepository = learningVideosRepository;
    }

    @GetMapping
    public Iterable<LearningVideos> list() {
        return learningVideosRepository.findAll();
    }

    @GetMapping(path = "/{videoTitle}")
    public Iterable<LearningVideos> getVideoByTitle(@PathVariable("videoTitle") String videoTitle) {
        return learningVideosRepository.findAllByVideoTitle(videoTitle);
    }
    
    @GetMapping(path = "/theme/{theme}")
    public Iterable<LearningVideos> getVideoByTheme(@PathVariable("theme") String theme){
        return learningVideosRepository.findAllByVideoTheme(theme);
    }

}