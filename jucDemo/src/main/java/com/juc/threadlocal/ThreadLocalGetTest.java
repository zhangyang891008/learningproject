package com.juc.threadlocal;

/**
 * Thread中的ThreadLocalMap存储变量，其KEY是一个弱引用，如果t的强引用消失以后，key引用的对象会立即被gc回收。避免造成内存泄漏，但是value不是弱引用还是会有内存泄漏问题
 *
 */
public class ThreadLocalGetTest {

    public static void main(String[] args) {
        ThreadLocal t = new ThreadLocal();
        t.set(new byte[1024*1024*10]);
        t = null;
//       / System.out.println(t.get());
        System.gc();

    }
}
