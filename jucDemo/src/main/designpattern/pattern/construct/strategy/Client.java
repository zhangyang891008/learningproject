package pattern.construct.strategy;

import java.math.BigDecimal;

/*
    策略模式：客户端需要知道所有的策略模式并选择需要使用哪个策略模式。
    策略模式是一种行为模式
 */
public class Client {

    public static void main(String[] args) {
        AliPayStrategy aliPayStrategy = new AliPayStrategy();
        BigDecimal money = new BigDecimal(10.00);
        StrategyContext strategyContext = new StrategyContext(aliPayStrategy);
        strategyContext.pay(money);
    }
}
