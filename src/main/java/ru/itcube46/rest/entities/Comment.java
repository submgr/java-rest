package ru.itcube46.rest.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("COMMENTS")
public class Comment {
    @Id
    private Long id;

    private Long userId;

    private Long postId;

    private String content;

    private Date publicationDate;
}
