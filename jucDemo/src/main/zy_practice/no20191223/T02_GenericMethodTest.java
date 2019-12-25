package no20191223;

import java.io.Serializable;

/*
1.泛型方法
 */
public class T02_GenericMethodTest {

    public static <T> T getMiddle(T ...args){
        int length = args.length;
        return args[length/2];
    }

    public static void main(String[] args) {
        String middle = T02_GenericMethodTest.getMiddle("String", "a", "b");
        Integer middle1 = T02_GenericMethodTest.getMiddle(1, 2, 3, 4);
        // 整型、浮点数、字符串混合
        Serializable string = T02_GenericMethodTest.getMiddle(1.2, 3, "test", 4.5, "String");
        Number middle2 = T02_GenericMethodTest.getMiddle(2, 1.3, 66f);
        System.out.println(middle);
        System.out.println(middle1);
        System.out.println(string.getClass());
        System.out.println(middle2.getClass());
    }
}
