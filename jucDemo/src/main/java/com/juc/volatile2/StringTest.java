package com.juc.volatile2;

public class StringTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = a;
        String d = new String("abc").toString();
        String e = "ab"+"c";
        //String temp = "c";

        String temp = new String("c");
        String f = "ab" + temp;
    /*    System.out.println(b.equals("abc"));  //值比较
        System.out.println(a.equals(f));
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == a);
        System.out.println(c == b);
        System.out.println("88888-----");
        System.out.println(d == a);
        System.out.println(d == b);
        System.out.println(d == c);
        System.out.println("777777------");
        System.out.println(e == a);
        System.out.println(e == b);
        System.out.println(e == c);
        System.out.println(e == d);
        System.out.println("00000-------");
        System.out.println(f == a);
        System.out.println(f == b);
        System.out.println(f == c);
        System.out.println(f == d);
        System.out.println(new StringBuilder().append("abc").toString());
*/

    }
}
