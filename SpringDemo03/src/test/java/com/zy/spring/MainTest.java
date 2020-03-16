package com.zy.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
    SpringDemo03：切面注解和配置文件两种练习
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
        /*
        Calculate calculate = ctx.getBean("calculate", Calculate.class);
        calculate.divide(1,0);
*/
        Calculate2 cal = ctx.getBean("calculate2", Calculate2.class);
        cal.add(1,2);
    }
}
