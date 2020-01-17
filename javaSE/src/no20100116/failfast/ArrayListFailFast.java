package no20100116.failfast;

import java.util.ArrayList;
import java.util.List;

/**
 *ArrayList remove()方法fail-fast
 *
 */
public class ArrayListFailFast {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("zero");
        for (String s: list){
            if("one".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
