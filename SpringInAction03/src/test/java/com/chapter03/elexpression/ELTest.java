package com.chapter03.elexpression;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
      El表达式测试：
        @Value("#{T(System).currentTimeMillis()}")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  AppConfig.class)
public class ELTest {

    @Autowired
    private ConfigurableBeanFactory factory;
    
    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            Object myDate = factory.getBean(MyDate.class);
            System.out.println(myDate);
        }
    }
}
