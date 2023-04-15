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
import org.springframework.web.bind.annotation.PutMapping;
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
    public Iterable<Post> getRecent() {
        Iterable<Post> posts = postsRepository.findAll();
        return StreamSupport.stream(posts.spliterator(), false)
                .sorted(Comparator.comparing(Post::getPublicationDate).reversed())
                .limit(10)
                .toList();
    }
    // curl -X GET http://localhost:8080/api/posts?recent

    @GetMapping(path = "/user/{id}")
    public Iterable<Post> getAllByUserId(@PathVariable("id") Long userId) {
        return postsRepository.findAllByUserId(userId);
    }
    // curl -X GET http://localhost:8080/api/posts/user/1

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post) {
        post.setPublicationDate(new Date());
        return postsRepository.save(post);
    }
    /*
     * curl -H "Content-Type: application/json" -X POST \
     * -d '{"userId":1,"title":"test","content":"test","views":0}' \
     * http://127.0.0.1:8080/api/posts/add
     */

    @PutMapping(path = "/put/{id}")
    public Post putPost(@PathVariable("id") Long id, @RequestBody Post post) {
        // post.setId(id);
        post.setPublicationDate(new Date());
        return postsRepository.save(post);
    }
    /*
     * curl -H "Content-Type: application/json" -X PUT \
     * -d '{"userId":1,"title":"New test","content":"...","views":0}' \
     * http://127.0.0.1:8080/api/posts/put/1
     */

    @PatchMapping(path = "/patch/{id}")
    public Post patchPost(@PathVariable("id") Long id, @RequestBody Post postPatch) {
        Post post = postsRepository.findById(id).get();
        if (postPatch.getTitle() != null) {
            post.setTitle(postPatch.getTitle());
        }
        if (postPatch.getContent() != null) {
            post.setContent(postPatch.getContent());
        }
        return postsRepository.save(post);
    }
    /*
     * curl -H "Content-Type: application/json" -X PATCH \
     * -d '{"userId":1,"title":"New title","content":"New Content","views":0}' \
     * http://127.0.0.1:8080/api/posts/patch/1
     */

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        postsRepository.deleteById(id);
    }
    // curl -X DELETE http://127.0.0.1:8080/api/posts/delete/66
}
