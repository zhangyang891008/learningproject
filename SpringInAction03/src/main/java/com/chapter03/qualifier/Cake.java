package com.chapter03.qualifier;

import org.springframework.stereotype.Component;

@Component(value = "cake")
public class Cake extends Desert {

    private String color = "cake";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "color='" + color + '\'' +
                '}';
    }
}
