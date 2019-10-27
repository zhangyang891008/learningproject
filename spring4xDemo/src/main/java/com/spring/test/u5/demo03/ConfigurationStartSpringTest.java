package com.spring.test.u5.demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationStartSpringTest {

    //1.通过传参方式注册一个配置类启动Spring容器
    public static void initMethod1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaApp.class);
        UserService bean = ctx.getBean(UserService.class);
        System.out.println(bean);

        Object getUserService = ctx.getBean("getUserService"); //方法名对应bean名称
        System.out.println(getUserService);
    }

    //2.注册多个配置文件启动
    public static void initMethod2(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaApp.class);
        ctx.register(JavaAppTwo.class);

        ctx.refresh();

        UserService bean = ctx.getBean(UserService.class);
        Person bean1 = ctx.getBean(Person.class);
        System.out.println(bean);
        System.out.println(bean1);
    }


    public static void main(String[] args) {
        //initMethod1();
        initMethod2();
    }
}
