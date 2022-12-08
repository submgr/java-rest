package com.example.rest.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private int userId;
    private String title;
    private String description;
    private Date dateOfCreation;
    private Date dateOfCompletion;
}
