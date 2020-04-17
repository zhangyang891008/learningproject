package com.chapter04.xml01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
    通过xml配置增强Around增强
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class XmlAspectTest {

    @Autowired
    private ConfigurableBeanFactory factory;

    @Test
    public void test(){
        IPerformance bean = factory.getBean(IPerformance.class);
        bean.perform();
    }
}
