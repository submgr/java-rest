package ru.itcube46.rest.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("DAILY_EVENTS")
public class DailyEvents {
    @Id
    private Long id;

    private Long quizId;
    
    private Date eventDate;

    private Date eventDate;

    private String eventName;

    private String difficulty;

    public Integer dailyScores;
}