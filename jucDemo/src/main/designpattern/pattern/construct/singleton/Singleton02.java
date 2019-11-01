package pattern.construct.singleton;

/**
 * 单例模式：静态内部类的方式实现
 */
public class Singleton02 {

    private Singleton02(){

    }

    private static class InstanceHolder{
        private static final Singleton02 INSTANCE = new Singleton02();
    }

    public static final Singleton02 getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public static void main(String[] args) {

    }
}
