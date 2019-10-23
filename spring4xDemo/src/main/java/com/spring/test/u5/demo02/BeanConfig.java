package com.spring.test.u5.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 通过注解@Configuration成为配置类，@Bean类似于beans.xml中的<bean id="OOO" class="XXX"></bean>
 */
@Configuration
public class BeanConfig {

    @Bean
    public Cup getCup(){
        System.out.println("init cup...");
        return new Cup("red");
    }
}
