package no20100116.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * lambda：predicate functional interface test
 *
 *
 */
public class PredicateTest {

    //判断单词长度是否超过5
    public static Predicate<String> getPredicateFunction(){
        return  s->s.length()>5;
    }

    public static List<String> fill(String content){
        ArrayList<String> ret = new ArrayList<>();
        String[] s = content.split(" ");
        ret = new ArrayList<>(Arrays.asList(s));
        return ret;
    }

    public static void main(String[] args) {
        List<String> fill = fill("hello world this is a test string");
        fill.stream().filter(getPredicateFunction()).forEach(System.out::println);
    }
}
