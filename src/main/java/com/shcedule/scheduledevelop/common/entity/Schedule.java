package com.shcedule.scheduledevelop.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")

    private Member member;

    public Schedule(){
    }

    public static Schedule of(String title, String writer, String contents, Member member){
        Schedule schedule = new Schedule();

        schedule.title = title;
        schedule.writer = writer;
        schedule.contents = contents;
        schedule.member = member;
        return schedule;
    }
}
