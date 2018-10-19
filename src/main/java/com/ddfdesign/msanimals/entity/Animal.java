package com.ddfdesign.msanimals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "born_date")
    private Date born_date;

    @Column(name = "sex")
    private String sex;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "status")
    private String status;

    @Column(name = "color")
    private String color;

    @Column(name = "father")
    private Long father;

    @Column(name = "mother")
    private Long mother;


    @Column(name = "death_date")
    private Date death_date;

    @Column(name = "client")
    private Long client;

    @Column(name = "sale")
    private Long sale;

    @Column(name = "breed")
    private Long breed;



}
