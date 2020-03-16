package com.zy.test;

import com.zy.entity.Computer;
import com.zy.entity.Person;
import com.zy.entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    SpringDemo01:练习通过配置文件初始化bean
 */
public class MainTest {
    public static void main(String[] args) {
        /* 1。测试通过构造函数、设置属性两种方式创建bean对象
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println(student);
        */

        /* 2。测试设置属性 set map list
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
        */

        /* 3.ref设置其他bean引用
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Computer computer = ctx.getBean("computer", Computer.class);
        System.out.println(computer);

         */
    }
}
