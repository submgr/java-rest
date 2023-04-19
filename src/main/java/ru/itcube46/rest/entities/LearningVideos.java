package ru.itcube46.rest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("LEARNING_VIDEOS")
public class LearningVideos {
    @Id
    private Long id;

    private String videoTitle;

    private String videoUrl;

    private String theme;
}