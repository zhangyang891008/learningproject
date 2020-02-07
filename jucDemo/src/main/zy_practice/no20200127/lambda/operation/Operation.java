package no20200127.lambda.operation;

import java.util.function.DoubleBinaryOperator;

/**
 * 枚举的应用
 */
public enum Operation {
    PLUS("+", (x,y)->x+y),
    MINUS("-",(x,y)->x-y),
    TIMES("*",(x,y)->x*y),
    DIVIDE("/",(x,y)->x/y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x,y);
    }
}
