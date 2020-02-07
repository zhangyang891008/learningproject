package no20191227;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*

    Predicate接口： 与、或、非判断、isEqual()、test()
 */
public class PredicateTest {

    public static Predicate<String> length(){

        return p-> p.length() > 5;
    }

    public static Predicate<String> contains(){
        return p->p.contains("d");
    }

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("green");
        colors.add("red");
        colors.add("purple");
        colors.add("darkblue");
        // test or
        List<String> collect = colors.stream().filter(length().or(contains())).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("");
        // test negate
        List<String> collect2 = colors.stream().filter(length().negate()).collect(Collectors.toList());
        collect2.forEach(System.out::println);
        System.out.println("");

        // test removeIf
        colors.removeIf(p->p.length()>5);
        colors.forEach(System.out::println);

    }
}
