package com.chapter03.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class AppConfig{
    @Bean
    public Desert cake(){
        return new Cake();
    }

    @Bean
    @Primary
    public Desert iceCream(){
        return new IceCream();
    }
}