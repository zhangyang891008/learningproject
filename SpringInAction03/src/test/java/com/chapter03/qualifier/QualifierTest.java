package com.chapter03.qualifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext4.xml")
public class QualifierTest {

    @Autowired
    @Qualifier("cake")
    private Desert desert;

    @Test
    public void test(){
        System.out.println(desert);
    }
}
