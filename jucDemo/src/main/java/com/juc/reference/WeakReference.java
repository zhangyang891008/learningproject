package com.juc.reference;

/**
 * 弱引用：如果一个对象只有弱引用指向它，将会在垃圾回收的时候被回收掉。
 * 通常与强引用配合使用，在强引用不再指向对象时，说明此对象不再需要，可以避免内存泄漏。
 * 使用场景：ThreadLocal 的map中的key，它是一个指向ThreadLocal的弱引用，一旦threadLocal不存在了，对象就会被回收，但是value仍然会导致内存泄漏，因此
 * 如果一个threadlocal不再需要，需要手动移除 tl.remove()
 */
public class WeakReference {

    public static void main(String[] args) {
        Object myObj = new Object();
        java.lang.ref.WeakReference<Object> weakObj = new java.lang.ref.WeakReference<>(myObj);

        System.out.println("init: " + myObj + ", weak: " +weakObj );

        myObj = null;
        System.gc();
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        System.out.println("after: "+ myObj + ", weak: " +weakObj.get() );
    }
}
