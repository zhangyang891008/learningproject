package com.zy.spring;

import org.springframework.stereotype.Component;

@Component(value="addr")
public class Address {
    @Override
    public String toString() {
        return ""+this.hashCode();
    }
}
