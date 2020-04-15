package com.example.newTest.Service;

import com.example.newTest.entity.Enroll;
import com.example.newTest.entity.Lesson;
import com.example.newTest.entity.Student;
import com.example.newTest.repositories.EnrollRepository;
import com.example.newTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EnrollRepository enrollRepository;

    public List<Student> getStudentList (Lesson lesson){
        String lessonFaculty = lesson.getLesson_faculty();
        String lessonDepartment = lesson.getLesson_department();
        List<Student> listStudent = studentRepository.findAll();
        List<Student> finalList = new ArrayList<>();
        for (int i = 0; i < listStudent.size(); i++){
            if (listStudent.get(i).getStudent_department() == lessonDepartment &&
                listStudent.get(i).getStudent_faculty() == lessonFaculty){
                finalList.add(listStudent.get(i));
            }
        }
        return finalList;
    }

    public ResponseEntity<Object> setEnroll (Lesson lesson, List<Student> students){
        for (int i = 0; i < students.size(); i++){
            Enroll enroll = new Enroll(null,students.get(i), lesson );
            enrollRepository.save(enroll);
        }
        return new ResponseEntity<>("Student registered successfully", HttpStatus.OK);
    }
}
