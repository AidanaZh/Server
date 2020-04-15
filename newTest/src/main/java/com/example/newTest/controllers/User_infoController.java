package com.example.newTest.controllers;
import com.example.newTest.entity.User_info;
import com.example.newTest.repositories.User_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class User_infoController {

    @Autowired
    public User_infoRepository user_infoRepository;

    @GetMapping("/list")
    public List<User_info> user_infoList (){
        return user_infoRepository.findAll();
    }

    @GetMapping("/{id}")
    public User_info show(@PathVariable String id){
        Integer newId = Integer.parseInt(id);
        return user_infoRepository.findById(newId).get();
    }

    @PostMapping("/save")
    public User_info save (@RequestBody User_info user_info){
        return user_infoRepository.save(user_info);
    }
}
