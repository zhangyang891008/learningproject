package com.chapter04.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    类的增强
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.chapter04.annotation.ConcertConfig.class)
public class AspectTest {

    @Autowired
    private Performance performance;

    @Test
    public void test(){
        performance.perform();
        System.out.println(performance);
    }
}
