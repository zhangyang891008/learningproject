package pattern.construct.strategy;

import java.math.BigDecimal;

//微信方式支付
public class WeixinPayStrategy implements IPayStrategy {
    @Override
    public void pay(BigDecimal money) {
        System.out.println("visit weixin pay interfaces :" + money);
    }
}
