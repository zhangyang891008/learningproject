package com.chapter03.elexpression;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyDate {

    @Value("#{T(System).currentTimeMillis()}")
    private long currentTimeMillis;

    @Override
    public String toString() {
        return super.toString() +" MyDate{" +
                "currentTimeMillis=" + currentTimeMillis +
                '}';
    }
}
