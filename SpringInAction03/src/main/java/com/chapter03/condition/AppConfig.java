package com.chapter03.condition;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:magic.properties")
public class AppConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
