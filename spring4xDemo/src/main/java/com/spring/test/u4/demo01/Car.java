package com.spring.test.u4.demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class Car implements BeanFactoryAware , BeanNameAware {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){}

    public Car(String brand, String color, int maxSpeed){
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println(" brand:"+this.brand+", color:"+this.color+", maxSpeed:"+this.maxSpeed);
    }

    /*定义初始化、销毁方法 ，方法名配置到beans.xml文件中 */
    public void myInit(){
        System.out.println("myInit...");
        introduce();
    }

    public void myDestory(){
        System.out.println("myDestory...");
        introduce();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /*
    beanFactoryAware
    */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("---beanFactory:"+beanFactory.toString());
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("---beanName:"+beanName);
    }
}
