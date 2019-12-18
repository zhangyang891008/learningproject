package no20191216;

import java.util.Optional;

/*
    optional使用
 */
public class OptionalTest {

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        Integer valueA = a.orElse(new Integer(0));
        Integer valueB = b.orElse(new Integer(0));
        return valueA+valueB;

    }

    public static void main(String[] args) {
        Optional<Integer> a = Optional.of(4); // not allow null value
        Optional<Integer> b = Optional.ofNullable(null);  // allow null value
        Integer sum = new OptionalTest().sum(a, b);
        System.out.println(sum);
    }
}
