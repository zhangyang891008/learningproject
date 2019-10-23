package com.spring.test.u5.demo01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Bike{
    private String brand;
    private String color;
    private int maxSpeed;

    public Bike(){
        this.brand = "redFlag";
        this.color = "blue";
        this.maxSpeed = 100;
    }

    public Bike(String color){
        this.color= color;
    }

    public void introduce(){
        System.out.println(" brand:"+this.brand+", color:"+this.color+", maxSpeed:"+this.maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
