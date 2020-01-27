package juc.class02.u1.singletontest;


/*
    1.饿汉式
 */
public class Singleton_Hunger {

    private static final Singleton_Hunger instance = new Singleton_Hunger();

    private Singleton_Hunger(){}

    public static Singleton_Hunger getInstance(){
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton_Hunger.getInstance());
        }

    }
}
