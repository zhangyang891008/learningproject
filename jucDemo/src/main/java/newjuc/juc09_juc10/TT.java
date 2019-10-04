package newjuc.juc09_juc10;

/**
 * synchronized获得的锁是可重入的，这个例子是子类方法调用父类同步方法可重入的例子
 */
public class TT {
    public synchronized void m(){
        System.out.println("I am super m()");
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.m();
    }
}

class Child extends TT{
    public synchronized void m(){
        System.out.println("I am child m() start...");
        super.m();
        System.out.println("I am child m() end...");

    }
}