package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Post;

public interface PostsRepository extends CrudRepository<Post, Long> {
    @Query("SELECT * FROM POSTS WHERE USER_ID = :uid")
    Iterable<Post> findAllByUserId(@Param("uid") Long userId);
}
