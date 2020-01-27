package no20200126.complex;

/**
 * 复数测试
 */
public class ComplexTest {

    public static void main(String[] args) {
        Complex zero = new Complex(0,0);
        Complex one = new Complex(1,0);
        Complex two = new Complex(2,0);
        Complex times = one.times(two);
        System.out.println(times);
    }
}


