package com.chapter04.xml;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
    通过xml配置文件配置增强，before after等
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class XmlAspectTest {

    @Autowired
    private ConfigurableBeanFactory factory;

    @Test
    public void test(){
        IPerformance bean = factory.getBean(IPerformance.class);
        bean.perform();
    }
}
