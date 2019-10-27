package juc.class02.u1.singletontest;


/*
    1.饿汉式
 */
public class T13_Singleton {

    private static final T13_Singleton instance = new T13_Singleton();

    private T13_Singleton(){}

    public static T13_Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(T13_Singleton.getInstance());
        }

    }
}
