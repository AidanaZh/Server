package com.example.newTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lesson_id;
    private String lesson_kod;
    private String lesson_faculty;
    private String lesson_department;
    private Integer lesson_week;
    private Boolean lesson_status;
    @ManyToOne
    @JoinColumn
    private Coach coach_id;
}
