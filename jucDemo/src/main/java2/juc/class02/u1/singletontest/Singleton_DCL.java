package juc.class02.u1.singletontest;

public class Singleton_DCL {
    private static volatile Singleton_DCL instance;

    private Singleton_DCL(){}

    public static Singleton_DCL getInstance(){
        if(instance == null){
            synchronized (Singleton_DCL.class){
                if(instance == null){
                    instance = new Singleton_DCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton_DCL.getInstance());
        }

    }
}
