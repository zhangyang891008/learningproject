package com.zy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Autowired默认根据类型进行注入
 * @Qualifier注解可以缩小注入的范围，但是如果不存在对应名称的bean也会导致注入失败
 */
@Component
public class Person {

    private String name;

    @Autowired()
    @Qualifier("addr")
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
