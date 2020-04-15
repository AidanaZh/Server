package com.example.newTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentRegister {
    private String student_kod;
    private String student_name;
    private String student_surname;
    private String student_faculty;
    private String student_department;
}
