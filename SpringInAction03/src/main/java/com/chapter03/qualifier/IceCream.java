package com.chapter03.qualifier;


import org.springframework.stereotype.Component;

@Component(value = "iceCream")
public class IceCream extends Desert {
    private String color="icecream";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "color='" + color + '\'' +
                '}';
    }
}
