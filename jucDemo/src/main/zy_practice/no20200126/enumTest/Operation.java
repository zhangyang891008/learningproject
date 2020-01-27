package no20200126.enumTest;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 枚举：effectiveJava
 *      将不同的行为与每个枚举常量关联起来：
 */
public enum Operation {
    PLUS{
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double apply(double x, double y) {
            return x -y;
        }
    },
    TIMES{
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE{
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    public abstract double apply(double x, double y);

}
