package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    public FeignService feignService;

    @Autowired
    public DiscoveryClient discoveryClient;

    @GetMapping("instances")
    public List<ServiceInstance> getInstances(){
        List<ServiceInstance> instances = discoveryClient.getInstances("localhost:provider:7000");
        return instances;
    }

    @GetMapping("service")
    public List<String> getServices(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        return services;
    }

    @GetMapping("hello")
    public String hello(){
        System.out.println("consumer: ---invoke hello");
        return feignService.hello();
    }
}
