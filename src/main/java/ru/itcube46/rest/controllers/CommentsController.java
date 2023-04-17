package ru.itcube46.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.Comment;
import ru.itcube46.rest.repositories.CommentsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "api/comments", produces = "application/json")
public class CommentsController {
    private CommentsRepository commentsRepository;

    public CommentsController(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @GetMapping(path = "/user/{id}")
    public Iterable<Comment> getAllByUserId(@PathVariable("id") Long userId) {
        return commentsRepository.findAllByUserId(userId);
    }

    @GetMapping(path = "/post/{id}")
    public Iterable<Comment> getAllByPostId(@PathVariable("id") Long postId) {
        return commentsRepository.findAllByPostId(postId);
    }
}
