package juc.class05.c022;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(softReference.get());

        byte[] newBytes = new byte[1024*1024*10];

        System.out.println("null"+softReference.get());
        //System.out.println(softReference);
    }
}
