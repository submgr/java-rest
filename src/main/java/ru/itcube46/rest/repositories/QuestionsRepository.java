package ru.itcube46.rest.repositories;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Questions;
public interface QuestionsRepository extends CrudRepository<Questions, Long> { 

   @Query("SELECT * FROM QUESTIONS WHERE QUESTION_SCORES = :questionScores")
    Iterable<Questions> doubleSumQuestionsScores(@Param("questionScores") Long questionScores);

    @Query("SELECT * FROM QUESTIONS WHERE QUESTION_SCORES = :questionScores")
    Iterable<Questions> findScoresByQuizId(@Param("questionScores") Long questionScores);

    @Query("SELECT * FROM QUESTIONS WHERE quiz_id = :quizId")
    Iterable<Questions> findQuestionsByQuizId(@Param("quizId") Long quizId);
}