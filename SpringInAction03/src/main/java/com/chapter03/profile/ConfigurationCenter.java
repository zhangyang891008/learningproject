package com.chapter03.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
public class ConfigurationCenter {

    @Bean
    @Profile("test")
    public MyEnv getTestEnv(){
        return new MyEnv("test");
    }

    @Bean
    @Profile("dev")
    public MyEnv getDevEnv(){
        return new MyEnv("dev");
    }
}
