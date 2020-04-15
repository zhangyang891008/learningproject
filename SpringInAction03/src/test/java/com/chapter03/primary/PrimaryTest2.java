package com.chapter03.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext3.xml")
public class PrimaryTest2 {

    @Autowired
    private Desert desert;

    @Test
    public void test(){
        System.out.println(desert);
    }
}
