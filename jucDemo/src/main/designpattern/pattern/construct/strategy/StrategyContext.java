package pattern.construct.strategy;

import java.math.BigDecimal;

public class StrategyContext {

    private IPayStrategy strategy = null;

    public StrategyContext(IPayStrategy strategy){
        this.strategy = strategy;
    }

    public void pay(BigDecimal money){
        strategy.pay(money);
    }
}
