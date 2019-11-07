package pattern.construct.strategy;

import java.math.BigDecimal;

//支付宝方式支付
public class AliPayStrategy implements IPayStrategy {

    @Override
    public void pay(BigDecimal money) {
        System.out.println("visit ali pay interfaces :" + money);
    }
}
