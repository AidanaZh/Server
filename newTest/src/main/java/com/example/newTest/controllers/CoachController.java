package com.example.newTest.controllers;

import com.example.newTest.Service.CoachService;
import com.example.newTest.entity.Coach;
import com.example.newTest.entity.CoachRegister;
import com.example.newTest.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    public CoachService coachService;
    @Autowired
    public CoachRepository coachRepository;

    @PostMapping("/register")
    public Coach coachRegister(@RequestBody CoachRegister coachRegister) {
        return coachService.coachRegister(coachRegister);
    }

    @GetMapping("/list")
    public List<Coach> coachList (){
        return coachRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coach getById(@PathVariable String id){
        Integer tempId = Integer.parseInt(id);
        return coachRepository.findById(tempId).get();
    }
}
