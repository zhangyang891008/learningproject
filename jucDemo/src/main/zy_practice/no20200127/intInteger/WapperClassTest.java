package no20200127.intInteger;

/**
 * 基本类型、基本类型包装类
 *
 */
public class WapperClassTest {

    static Integer val;
    public static void main(String[] args) {
        //case1:通过new创建对象，不能够复用
        Integer v1 = new Integer(44);
        Integer v2 = new Integer(44);
        System.out.println(v1.compareTo(v2));
        System.out.println(v1==v2);

        //case1:不通过new的方式创建，进行优化，使用了缓存
        Integer v3 = Integer.valueOf(11);
        Integer v4 = Integer.valueOf(11);
        System.out.println(v3.compareTo(v4));
        System.out.println(v3==v4);

        //case2:为初始化的integer,此处会报异常NPE，因为包装类和基本类型进行比较会自动拆箱，为初始化的val拆箱后是null
        if(val == 0)
            System.out.println("equal");
        System.out.println("unbelievable");


    }
}
