package com.sprint.test.u5.demo03;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigAppFour.class)
public class ConfigAppThree {

    @Bean
    public Dog getDog(){
        return new Dog();
    }
}
