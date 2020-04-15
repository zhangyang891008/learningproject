package com.chapter03.xmlprimary;

public class Cake extends Desert {
    private String color;

    public Cake(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "color='" + color + '\'' +
                '}';
    }
}
