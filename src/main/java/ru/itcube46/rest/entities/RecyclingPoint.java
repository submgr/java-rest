package ru.itcube46.rest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("RECYCLING_POINTS")
public class RecyclingPoint {
    @Id
    private Long id;

    private String city;

    private Double latitude;

    private Double longitude;

    private String specialization;

    private String organization;

    private String phone;

    private String receptionDays;
}
