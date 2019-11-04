package juc.class05.c022;

        import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> reference = new WeakReference<Object>(o);
        System.out.println(reference.get());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        o = null;
        System.gc();
        System.out.println(reference.get());

    }
}
