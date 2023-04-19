package ru.itcube46.rest.repositories;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Questions;
public interface QuestionsRepository extends CrudRepository<Questions, Long> { 

   @Query("SELECT QUESTION_SCORES FROM QUESTIONS WHERE QUESTION_SCORES = :questionScores")
    Iterable<Questions> doubleSumQuestionsScores(@Param("questionScores") Long questionScores);


}
