package com.juc.reference;

/**
 * 四种引用之软引用
 */
public class SoftReference {

    public static void main(String[] args) {
        java.lang.ref.SoftReference<byte[]> softReference = new java.lang.ref.SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        //System.gc();

        System.out.println("after gc..." + softReference.get());

        byte[] newbytes = new byte[1024*1024*11];
        System.out.println("after new bytes " +  softReference.get());
    }
}
