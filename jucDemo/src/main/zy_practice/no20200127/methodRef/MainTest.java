package no20200127.methodRef;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class MainTest {
    public static void print(Map<String,Integer> map){
        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);

        map.merge("a",100,(count,incr)-> count+incr);
        print(map);

        map.merge("b",222,Integer::sum);
        print(map);

    }
}
