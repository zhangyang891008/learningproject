package com.example.controller;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private Student student;

    @RequestMapping("student")
    public void getStudent(){
        System.out.println(student);
    }
}
