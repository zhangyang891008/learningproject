package com.chapter03.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
通过JavaConfig配置首选项
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  AppConfig.class)
public class PrimaryTest {

    @Autowired
    private Desert desert;

    @Test
    public void getDesert(){
         System.out.println(desert);
    }
}
