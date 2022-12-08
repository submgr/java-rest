package com.example.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecyclingPoint {
    private int id;
    private String city;
    private double latitude;
    private double longitude;
    private String specialization;
    private String organization;
    private String phone;
    private String receptionDays;
}
