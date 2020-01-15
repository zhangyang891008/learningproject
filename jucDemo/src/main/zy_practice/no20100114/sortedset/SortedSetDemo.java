package no20100114.sortedset;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo{

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "good morning I am zhangyang this is a cat".split(" "));
        sortedSet.stream().forEach(System.out::println);
        System.out.println("*****");
        //-----------
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        //------iterator-----
        Iterator<String> iterator = sortedSet.iterator();
        System.out.println("------iterator------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //-------------
        System.out.println("------subList------");
        SortedSet<String> strings = sortedSet.subSet("am", "is");
        strings.stream().forEach(System.out::println);


    }
}
