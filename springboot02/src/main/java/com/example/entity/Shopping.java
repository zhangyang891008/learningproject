package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//两个成员属性都是自定义的，无法自动注入，需要自定义converter：WeightConverter
@Component
@ConfigurationProperties("shopping")
public class Shopping {

    private Weight fruit;
    private Weight meat;

    public Weight getFruit() {
        return fruit;
    }

    public void setFruit(Weight fruit) {
        this.fruit = fruit;
    }

    public Weight getMeat() {
        return meat;
    }

    public void setMeat(Weight meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "fruit=" + fruit +
                ", meat=" + meat +
                '}';
    }
}
