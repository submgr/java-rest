package ru.itcube46.rest.controllers;

import java.util.Comparator;
import java.util.Date;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.itcube46.rest.entities.Post;
import ru.itcube46.rest.repositories.PostsRepository;

@RestController
@RequestMapping(path = "api/posts", produces = "application/json")
public class PostsController {
    private PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Post> recentPosts() {
        Iterable<Post> posts = postsRepository.findAll();
        return StreamSupport.stream(posts.spliterator(), false)
                .sorted(Comparator.comparing(Post::getPublicationDate).reversed())
                .limit(10)
                .toList();
    }

    @GetMapping(path = "/user/{id}")
    public Iterable<Post> getAllByUserId(@PathVariable("id") Long userId) {
        return postsRepository.findAllByUserId(userId);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        post.setPublicationDate(new Date());
        return postsRepository.save(post);
    }

    @PatchMapping(path = "/update/{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post postPatch) {
        Post post = postsRepository.findById(id).get();
        if (postPatch.getTitle() != null) {
            post.setTitle(postPatch.getTitle());
        }
        if (postPatch.getContent() != null) {
            post.setContent(postPatch.getContent());
        }
        return postsRepository.save(post);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        postsRepository.deleteById(id);
    }
}
