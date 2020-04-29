package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class Weight {
    private Integer number;
    private String unit;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "number=" + number +
                ", unit='" + unit + '\'' +
                '}';
    }
}
