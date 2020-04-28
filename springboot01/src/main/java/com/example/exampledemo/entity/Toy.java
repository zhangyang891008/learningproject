package com.example.exampledemo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("toy.properties")
public class Toy {

    @Value("${toy.color}")
    private String color;
    @Value("${toy.size}")
    private Integer size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
