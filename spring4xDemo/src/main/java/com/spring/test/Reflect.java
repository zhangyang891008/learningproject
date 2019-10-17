package com.spring.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Spring4.x unit4:最简单的反射
 */
public class Reflect {

    public static Car initCar() throws Throwable{
        System.out.println("init");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.spring.test.Car");

        Constructor constructor = clazz.getDeclaredConstructor();
        Car car = (Car) constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"audi");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"blue");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,100);
        return car;


    }
    public static void main(String[] args) throws Throwable {
        Car car = initCar();
        car.introduce();
        System.out.println("hello");
    }
}
