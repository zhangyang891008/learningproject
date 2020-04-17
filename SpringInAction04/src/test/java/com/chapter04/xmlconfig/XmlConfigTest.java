package com.chapter04.xmlconfig;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-xmlconfig.xml")
public class XmlConfigTest {

    @Autowired
    private IPerformance performance;

    @Test
    public void test(){
        performance.perform();
    }
}
