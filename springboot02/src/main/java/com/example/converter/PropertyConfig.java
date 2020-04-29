package com.example.converter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//开启自定义的Converter
@Configuration
public class PropertyConfig {

    @Bean
    @ConfigurationPropertiesBinding
    public WeightConverter weightConverter(){
        return new WeightConverter();
    }
}
