package no20191223;

import java.util.ArrayList;
import java.util.List;

/*
    7.超类型通配符：可以安全的传递一个类型对象到泛型类型中。

 */
public class T07_GenericSuperTest {

    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new RedApple());
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        T07_GenericSuperTest.writeTo(apples);
        for (Apple apple : apples) {
            System.out.println(apple.getClass().getSimpleName());
        }
    }
}

class Fruit{

}

class Apple extends Fruit{

}

class RedApple extends Apple{

}