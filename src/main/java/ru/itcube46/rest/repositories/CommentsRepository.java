package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long> {
    @Query("SELECT * FROM COMMENTS WHERE USER_ID = :uid")
    Iterable<Comment> findAllByUserId(@Param("uid") Long userId);

    @Query("SELECT * FROM COMMENTS WHERE POST_ID = :pid")
    Iterable<Comment> findAllByPostId(@Param("pid") Long postId);
}
