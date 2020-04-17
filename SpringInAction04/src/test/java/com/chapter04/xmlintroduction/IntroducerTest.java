package com.chapter04.xmlintroduction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    引介增强配置文件版本测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-xmlintroduction.xml")
public class IntroducerTest {

    @Autowired
    private IPerformance performance;

    @Test
    public void test(){
        performance.perform();
        Encoreable encoreable = (Encoreable) this.performance;
        encoreable.perfromEncore();
    }
}
