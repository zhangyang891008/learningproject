package com.juc.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    static ThreadLocal<Person> person = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.set(new Person());
                String name = person.get().name;
                System.out.println(name);
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.set(new Person());
                person.get().name = "lisi";
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(person.get().name);
            }
        });

        t2.start();
        t1.start();

    }


}

class Person{
    String name = "zhangsan";
}
