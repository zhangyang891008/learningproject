package no20191226;

import java.util.function.UnaryOperator;

/*
    20191226 UnaryOperator : 是Function 的一个功能接口，总是返回与输入值类型相同的返回值，默认方法返回输入值
 */
public class UnaryOperatorTest {

    public static void m(int input){
        UnaryOperator<Integer> operator = t-> 2*t;

        Integer apply = operator.apply(input);
        System.out.println(apply);
    }

    public static void m2(){
        UnaryOperator<Integer> oper1 = t -> t + 10;
        UnaryOperator<Integer> oper2 = t -> t * 10;

        Integer apply1 = oper1.compose(oper2).apply(9);
        System.out.println(apply1);

        Integer apply = oper1.andThen(oper2).apply(9);
        System.out.println(apply);


    }

    public static void main(String[] args) {
        m(5);

        m2();
    }
}
