package com.spring.test.u5.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaApp {
    @Bean
    public DaoService getDaoService(){
        return new DaoService();
    }

    @Scope("prototype")
    @Bean
    public UserService getUserService(){
        return new UserService();
    }

}
