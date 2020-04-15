package com.chapter03.xmlprimary;

import org.springframework.stereotype.Component;

@Component
public class IceCream extends Desert {

    private String color;

    public IceCream(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "color='" + color + '\'' +
                '}';
    }
}
