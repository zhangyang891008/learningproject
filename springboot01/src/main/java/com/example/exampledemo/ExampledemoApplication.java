package com.example.exampledemo;

import com.example.exampledemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class ExampledemoApplication {

    public static void main(String[] args) {
        System.out.println("hello spring boot");
        SpringApplication.run(ExampledemoApplication.class, args);
    }

}
