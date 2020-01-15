package no20100114.collectioncommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * java编程思想
 * collection常用操作练习
 *
 */
public class CollectionMethods {

    public static Collection getCollection(){
        Collection<String> coll = new ArrayList<>();
        coll.add("lily");
        coll.add("lucy");
        coll.add("tom");
        return coll;
    }

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.addAll(getCollection());
        c.add("five");
        c.add("six");
        System.out.println(c);
        //----list to array
        Object[] objects = c.toArray();
        Arrays.stream(objects).forEach(a-> System.out.println(a.toString()));
        String[] strings = c.toArray(new String[c.size()]);

        Arrays.stream(strings).forEach(s-> System.out.println(s.toString()));

        //----max, min
        System.out.println("max:"+Collections.max(c));
        System.out.println("min:"+Collections.min(c));

        //----test addAll and remove

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(getCollection());

        c.addAll(c2);
        System.out.println("----connection----");
        c.stream().forEach(System.out::println);

        c.remove("lily");
        System.out.println("----connection remove----");
        c.stream().forEach(System.out::println);

        c.remove("lily");
        System.out.println("----connection remove----");
        c.stream().forEach(System.out::println);

        Collection<String> c3 = new ArrayList<>();
        c3.add("lucy");

        c.retainAll(c3);
        System.out.println("----connection retain----");
        c.stream().forEach(System.out::println);

    }


}
