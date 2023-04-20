package ru.itcube46.rest.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Questions;
public interface QuestionsRepository extends CrudRepository<Questions, Long> { 
    
    @Query("SELECT * FROM QUESTIONS WHERE QUESTION_SCORES = :questionScores")
    Iterable<Questions> findScoresByQuizId(@Param("questionScores") Long questionScores);

    @Query("SELECT * FROM QUESTIONS WHERE quiz_id = :quizId")
    Iterable<Questions> findQuestionsByQuizId(@Param("quizId") Long quizId);

    //@Query("SELECT  CASE WHEN EXISTS (SELECT *FROM QUESTIONS WHERE ANSWER = :answer )THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END")
    //Iterable<Questions> checkAnswerInTable(@Param("answer") String answer);

    @Query("SELECT ANSWER FROM QUESTIONS WHERE ID = :questionId")
    String findAnswersByQuestion(@Param("questionId" ) Long questionId);
    
    @Query("SELECT * FROM QUESTIONS WHERE quiz_name = :quizName")
    Iterable<Questions> findQuestionsByQuizName(@Param("quizName") String quizName);
    
}