package ru.itcube46.rest.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("POSTS")
public class Post {
    @Id
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private Date publicationDate;

    private Integer views;
}
