package no20191223;
/*
2.类型变量的限定:
       T extends Comparable

 */
public class T01_GenericExtendsTest {

    public static <T extends Comparable> T getMin(T[] a){
        if(a == null || a.length ==0)
            return null;
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0)
                min = a[i];
        }
        return min;
    }
    public static void main(String[] args) {
        String[] arr = {"aa","bb","ab","cc"};
        String min = T01_GenericExtendsTest.getMin(arr);
        System.out.println(min);
    }
}
