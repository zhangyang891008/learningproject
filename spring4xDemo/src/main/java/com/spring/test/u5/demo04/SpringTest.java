package com.spring.test.u5.demo04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        String path = "com.spring.test.u5.demo04/beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        UserService userService = (UserService)ctx.getBean("userService1");
        System.out.println(userService);
        UserService userService0 = (UserService)ctx.getBean("userService1");
        System.out.println(userService0);
        UserService userService2  = (UserService)ctx.getBean("userService2");
        System.out.println(userService2);
        UserService userService3  = (UserService)ctx.getBean("userService2");
        System.out.println(userService3);
    }
}
