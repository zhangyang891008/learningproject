package no20100116.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合视图：转换后的集合不支持涉及修改长度的操作，如删除，插入等。
 *
 */
public class ArraysAsList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        //case 1 没有指定转换的数组类型，类型信息丢失
        Object[] objects = list.toArray(); //类型丢失

        //case 2 因为数组array2的长度比list短，所以转换后会将数组中的内容置空
        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        //case 3
        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }
}
