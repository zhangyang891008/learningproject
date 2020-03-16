package com.zy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
SpringDemo02:通过包扫描的方式
 */
public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println(student);


        //2.测试注解@Autowired
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);

        /*3.测试注解@Configuration @Primary
            Primary可以解决多个同类型注解的冲突问题，标注该注解的设置为优先注入
         */
        Computer computer = ctx.getBean("computer", Computer.class);
        System.out.println(computer);
    }
}

