package com.spring.test.u4.demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
自定义的processor
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("&&postProcessBeforeInitialization invoke..:"+beanName);
        Car car = (Car) bean;
        if(car.getColor()==null){

            car.introduce();
            car.setColor(" purple");
            System.out.println(" set color"+ car.getColor());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("&&postProcessAfterInitialization..");
        Car car = (Car) bean;
        if(car.getMaxSpeed()>200){
            car.setMaxSpeed(200);
            System.out.println(" speed greater than 200 ,reset!");
        }
        return bean;
    }
}
