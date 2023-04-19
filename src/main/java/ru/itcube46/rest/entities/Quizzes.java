package ru.itcube46.rest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("QUIZZES")
public class Quizzes {
    @Id
    private Long id;

    private String title;

    private String theme;

    private String difficulty;
}