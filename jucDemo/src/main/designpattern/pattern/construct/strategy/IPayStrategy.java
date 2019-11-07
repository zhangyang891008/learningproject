package pattern.construct.strategy;

import java.math.BigDecimal;

//支付策略接口
public interface IPayStrategy {

//    /void pay();

    void pay(BigDecimal money);
}
