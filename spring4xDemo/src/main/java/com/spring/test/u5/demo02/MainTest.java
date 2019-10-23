package com.spring.test.u5.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainTest {

    private static void LifeCycleInBeanFactory(){

        String path = "com.spring.test.u5.demo02/beans.xml";
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{path});
        Boss boss = (Boss)factory.getBean("boss");

        boss.introduce();

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
