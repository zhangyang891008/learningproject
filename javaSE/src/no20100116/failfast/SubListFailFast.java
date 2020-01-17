package no20100116.failfast;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class SubListFailFast {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        List subList = list.subList(0, 2);
        subList.stream().forEach(System.out::println);
        //以下对于表结构的调整都会导致subList的失败
        list.remove(1);
        list.add("zero");
        list.clear();

        //subList.add("test");
        subList.remove(0);
        subList.clear();
    }

}
