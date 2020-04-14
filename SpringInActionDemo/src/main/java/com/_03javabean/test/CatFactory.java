package com._03javabean.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CatFactory {
    @Bean
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("miaomiao");
        cat.setWeight(112);
        return cat;
    }
}
