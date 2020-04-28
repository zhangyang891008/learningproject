package com.example.exampledemo.Controller;

import com.example.exampledemo.entity.Student;
import com.example.exampledemo.entity.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Student student;

    @Autowired
    private Toy toy;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("student-----");
        System.out.println(student);
        System.out.println("toy-----");
        System.out.println(toy);
        return "hello spring boot!";
    }
}
