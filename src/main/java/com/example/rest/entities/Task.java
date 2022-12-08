package com.example.rest.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private String coords_latitude;
    private String coords_longitude;
    private String organisation;
    private int number;
}
