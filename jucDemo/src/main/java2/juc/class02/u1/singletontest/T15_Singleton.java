package juc.class02.u1.singletontest;


/*
    通过静态内部类实现
 */
public class T15_Singleton {

    private T15_Singleton(){}

    //private ：别人只能通过方法拿到
    private static class InstanceHolder{
        private static final T15_Singleton instance = new T15_Singleton();
    }

    public static T15_Singleton getInstance(){
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {

    }
}
