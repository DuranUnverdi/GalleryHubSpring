package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date creatTime;

}
