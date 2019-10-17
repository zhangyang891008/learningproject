package com.spring.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MainTest {

    private static void LifeCycleInBeanFactory(){
        ClassPathResource res = new ClassPathResource("com.spring.test/u4/demo01/beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        Car car = factory.getBean(Car.class);
        car.introduce();
        car.setColor("red**");
        car.introduce();

        //默认是单例，多次获取都是相同的对象
        Car car2 = factory.getBean(Car.class);
        System.out.println("equals?"+(car == car2));

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
