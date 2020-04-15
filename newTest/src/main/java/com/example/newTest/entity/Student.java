package com.example.newTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String student_kod;
    private String student_name;
    private String student_surname;
    private String student_faculty;
    private String student_department;
    @OneToOne
    @JoinColumn
    private User_info user_id;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
}
