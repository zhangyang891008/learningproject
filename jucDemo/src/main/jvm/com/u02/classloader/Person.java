package com.u02.classloader;

public class Person {
    String name;

    public String getName() {
        System.out.println("name: "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
