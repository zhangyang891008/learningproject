package newjuc.juc18_02;

import sun.misc.Unsafe;

/**
 * unsafe的实例普通类加载器加载的代码无法调用
 */
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