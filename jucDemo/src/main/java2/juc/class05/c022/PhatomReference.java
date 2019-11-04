package juc.class05.c022;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PhatomReference {

    public static void main(String[] args) {
        Object o = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference reference = new PhantomReference(o, queue);
        try {
            System.out.println(queue.remove(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        o = null;

        try {
            System.out.println(queue.remove(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.gc();

        try {
            System.out.println(queue.remove(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
