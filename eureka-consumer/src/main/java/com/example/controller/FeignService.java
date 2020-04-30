package com.example.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "provider",value = "")
public interface FeignService {

    @GetMapping("hello")
    public String hello();
}
