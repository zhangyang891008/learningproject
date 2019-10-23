package com.spring.test.u5.demo01;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * 实现FactoryBean接口以后，Spring容器将通过调用getObject()获取实例
 */
@Service
public class CupFactory implements FactoryBean<Cup> {

    @Override
    public Cup getObject() throws Exception {
        return new Cup("blue");
    }

    @Override
    public Class<?> getObjectType() {
        return Cup.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


}
