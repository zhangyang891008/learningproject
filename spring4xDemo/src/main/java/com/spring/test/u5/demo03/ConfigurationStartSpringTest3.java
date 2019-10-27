package com.spring.test.u5.demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationStartSpringTest3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ConfigAppThree中导入了AppFour的配置
        ctx.register(LogonAppConfig.class);
        ctx.refresh();
        LogonService bean = ctx.getBean(LogonService.class);
        System.out.println(bean);
    }
}
