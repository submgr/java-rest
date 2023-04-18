package ru.itcube46.rest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("QUESTIONS")
public class Questions {
    @Id
    private Long id;

    private String difficulty;

    private String question;

    private String answer;
    
    private Integer question_scores;
    
}
