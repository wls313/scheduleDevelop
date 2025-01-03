package com.shcedule.scheduledevelop.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;
}
