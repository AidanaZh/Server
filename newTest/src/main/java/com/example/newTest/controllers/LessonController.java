package com.example.newTest.controllers;

import com.example.newTest.Service.LessonService;
import com.example.newTest.entity.Lesson;
import com.example.newTest.entity.Student;
import com.example.newTest.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    public LessonRepository lessonRepository;

    @Autowired
    public LessonService lessonService;
    @GetMapping("/list")
    public List<Lesson> lessonList (){
        return lessonRepository.findAll();
    }

    @PostMapping("/register1")
    public List<Student> getStudentList (@RequestBody Lesson lesson){
        return lessonService.getStudentList(lesson);
    }

    @PostMapping("/register2")
    public ResponseEntity<Object> setEnroll (@RequestBody Lesson lesson, @RequestBody List<Student> enrolledStudnets){
        return lessonService.setEnroll(lesson,enrolledStudnets);
    }

    @GetMapping("/{id}")
    public Lesson getById(@PathVariable String id){
        Integer tempId = Integer.parseInt(id);
        return lessonRepository.findById(tempId).get();
    }
}
