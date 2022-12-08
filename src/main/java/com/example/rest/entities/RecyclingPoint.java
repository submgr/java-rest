package com.example.rest.entities;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecyclingPoint {
    private int id;
    private String city;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String specialization;
    private String organization;
    private String phone;
    private String receptionDays;
}
