package com.sprint.test.u5.demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationStartSpringTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ConfigAppThree中导入了AppFour的配置
        ctx.register(ConfigAppThree.class);
        ctx.refresh();
        Dog bean = ctx.getBean(Dog.class);
        System.out.println(bean);
    }

}
