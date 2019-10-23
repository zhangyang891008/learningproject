package com.spring.test.u5.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainTest {

    private static void LifeCycleInBeanFactory(){
/*
        //0.0 这种方式是不能支持注解的
        ClassPathResource res = new ClassPathResource("com.spring.test.u5.demo01/beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
*/
        /**
         * 0.1 Application才能支持注解
         */

        String path = "com.spring.test.u5.demo01/beans.xml";
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{path});

        Boss boss = (Boss)factory.getBean("boss");
        boss.introduce();

        Bike bike = (Bike)factory.getBean("bike");

        /**
         * 1.0工厂类测试
         */
        Object cup = factory.getBean(CupFactory.class);
        System.out.println(cup.getClass().toString());

        /**
         *  1.1如果传参是名称，则返回的是其生成的Cup,想获得工厂对象本身需要加&
         * com.spring.test.u5.demo01.Cup@1033576a
         * com.spring.test.u5.demo01.CupFactory@303cf2ba
         */

        Object cupFactory = factory.getBean("cupFactory");
        System.out.println(cupFactory);
        Object bean = factory.getBean("&cupFactory");
        System.out.println(bean);
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
