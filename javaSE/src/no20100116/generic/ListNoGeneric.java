package no20100116.generic;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型容器：
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        //list
        List al = new ArrayList();
        al.add(new Object());
        al.add(new Integer(1));
        al.add(new String("myString"));

        //list with object generic
        List<Object> oList = new ArrayList<>();
        oList.add(new Object());
        oList.add(new Integer(2));
        oList.add(new String("myOString"));

        //List<Integer>
        List<Integer> iList = new ArrayList<>();
        iList.add(new Integer(1));
        //iList.add(new Object());
        //iList.add(new String("testString"));

        //list generic
        List<?> genericList = new ArrayList<>();
        /*
        genericList.add(new Object());
        genericList.add(new String("genericString"));
        genericList.add(new Integer(13));
        */

        //list
        List<?> genericList2 = al;
        genericList2.stream().forEach(System.out::println);

        //数组是协变的，泛型不是协变的
        /**
         * incompatible types:
         * required: java.util.List<java.lang.Object>
         * found: java.util.List<java.lang.lnteger>
         */
        List<Integer> intList = new ArrayList<Integer>(3);
        intList.add(111);
        //compile error : 类型不匹配
        //List<Object> objectList = intList;

    }
}
