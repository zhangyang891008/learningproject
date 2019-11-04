package com.u02.classloader;

public class MainTest {

    public static void main(String[] args) {
        Child d = new Child();
        MyClassLoader myClassLoader = new MyClassLoader(d.getClass().getClassLoader());
        try {
            Class<?> aClass = myClassLoader.loadClass("com.u02.classloader.Person", false);
            System.out.println(aClass.toString());
            //Person p = (Person)aClass.newInstance();
            System.out.println(aClass.getClassLoader());
            Person p = (Person)aClass.newInstance();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
