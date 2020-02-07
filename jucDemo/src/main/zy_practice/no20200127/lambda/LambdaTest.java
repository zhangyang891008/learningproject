package no20200127.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 能用lambda不用匿名类，能用函数引用不用lambda
 *
 */
public class LambdaTest {
    public static void main(String[] args) {
        //1.匿名类
        List<String> words = Arrays.asList("world hello bye zhangsan lisi".split(" "));
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        words.stream().forEach(System.out::println);

        //2.lambda
        List<String> words1 = Arrays.asList("world hello bye zhangsan lisi".split(" "));
        Collections.sort(words1, (s1,s2)->Integer.compare(s1.length(),s2.length()));
        words1.stream().forEach(System.out::println);

        //3.
        List<String> words2 = Arrays.asList("world hello bye zhangsan lisi".split(" "));
        Collections.sort(words2, Comparator.comparingInt(String::length));

        List<String> words3 = Arrays.asList("world hello bye zhangsan lisi".split(" "));
        Collections.sort(words3,Comparator.comparing(String::length));
    }
}
