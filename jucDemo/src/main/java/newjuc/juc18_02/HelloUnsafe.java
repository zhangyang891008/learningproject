package newjuc.juc18_02;

import sun.misc.Unsafe;

public class HelloUnsafe {

    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
        try {
            Object o = unsafe.allocateInstance(Student.class);
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}

class Student{
    String name;
    int age;
}