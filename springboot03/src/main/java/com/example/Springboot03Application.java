package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Springboot03Application {

    public static void main(String[] args) {
        System.out.println("hello @EnableConfigurationProperties");
        SpringApplication.run(Springboot03Application.class, args);
    }

}
