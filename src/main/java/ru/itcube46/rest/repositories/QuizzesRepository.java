package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Quizzes;

public interface QuizzesRepository extends CrudRepository<Quizzes, Long> {
    /*@Query("SELECT * FROM QUESTIONS WHERE QUESTION_ID = :qid AND DIFFICULTY = :difficulty")
    Iterable<Questions> findAllByQuestionIdAndDifficulty(@Param("qid") Long questionId, @Param("difficulty") String difficulty);
*/
    @Query("SELECT * FROM QUIZZES WHERE DIFFICULTY = :difficulty")
    Iterable<Quizzes> findAllByDifficulty(@Param("difficulty") String difficulty);
    
}