package com.chapter04.annotation01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    接口的增强
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.chapter04.annotation01.ConcertConfig.class)
public class AspectTest {

    @Autowired
    private IPerformance performance;

    @Test
    public void test(){
        performance.perform();
        System.out.println(performance);
    }
}
