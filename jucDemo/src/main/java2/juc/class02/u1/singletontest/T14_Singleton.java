package juc.class02.u1.singletontest;

public class T14_Singleton {
    private static volatile T14_Singleton instance;

    private T14_Singleton(){}

    public static T14_Singleton getInstance(){
        if(instance == null){
            synchronized (T14_Singleton.class){
                if(instance == null){
                    instance = new T14_Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(T14_Singleton.getInstance());
        }

    }
}
