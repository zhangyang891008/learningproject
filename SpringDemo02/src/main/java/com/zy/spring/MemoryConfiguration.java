package com.zy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MemoryConfiguration {

    @Bean

    public Memory produceMemory(){
        return new Memory(4);
    }

    @Bean
    @Primary
    public Memory produceMemorySecond(){
        return new Memory(2);
    }
}
