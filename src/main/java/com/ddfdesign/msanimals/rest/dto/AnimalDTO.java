package com.ddfdesign.msanimals.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {

    private Long id;
    private String name;
    private java.sql.Date born_date;
    private String sex;
    private Double weight;
    private String status;
    private String color;
    private Long father;
    private Long mother;
    private java.sql.Date death_date;
    private Long client;
    private Long sale;
    private Long breed;
}
