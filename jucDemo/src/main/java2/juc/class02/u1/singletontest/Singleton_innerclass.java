package juc.class02.u1.singletontest;


/*
    通过静态内部类实现
 */
public class Singleton_innerclass {

    private Singleton_innerclass(){}

    //private ：别人只能通过方法拿到
    private static class InstanceHolder{
        private static final Singleton_innerclass instance = new Singleton_innerclass();
    }

    public static Singleton_innerclass getInstance(){
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {

    }
}
