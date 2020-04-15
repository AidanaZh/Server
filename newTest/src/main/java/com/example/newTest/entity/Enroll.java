package com.example.newTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enroll_id;
    @ManyToOne
    @JoinColumn
    private Student student_id;
    @ManyToOne
    @JoinColumn
    private Lesson lesson_id;
}
