package no20100116.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 */
public class FunctionTest {

    public static Function<Integer, Integer>  getAddFunction(){
        return (a)-> a.intValue()  + 3;
    }

    public static Function<Integer,Integer>  getMultiFunction(){
        return (b)->b.intValue() * 2;
    }

    public static BiFunction<Integer,Integer, Integer> getAddBiFunction(){
        return (a,b)->b.intValue() + a.intValue();
    }

    public static void main(String[] args) {

        Integer apply = getAddBiFunction().apply(10, 10);
        System.out.println(apply);

        Function<Integer, Integer>  andThenFunction = getAddFunction().andThen(getMultiFunction());
        Integer apply1 = andThenFunction.apply(1);
        System.out.println(apply1);

        Function<Integer, Integer>  andThenFunction2 = getMultiFunction().andThen(getAddFunction());
        Integer apply2 = andThenFunction2.apply(2);
        System.out.println(apply2);

        BiFunction<Integer, Integer, Integer> andThen3 = getAddBiFunction().andThen(getAddFunction());
        System.out.println(andThen3.apply(1,2));

    }
}
