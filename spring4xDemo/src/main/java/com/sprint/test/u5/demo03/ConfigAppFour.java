package com.sprint.test.u5.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAppFour {
    @Bean
    public Person getPerson(){
        return new Person();
    }
}
