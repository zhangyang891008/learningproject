package com.chapter03.propertysource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    通过properties文件注入外部的值，通过@PropertySource注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ExpressiveConfigTest {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void test(){
        System.out.println(blankDisc);
    }
}
