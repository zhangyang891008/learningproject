package com.juc.reference;

/**
 * 四种引用之强引用
 *
 */
public class StrongReference {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after gc:" + o);
    }
}
