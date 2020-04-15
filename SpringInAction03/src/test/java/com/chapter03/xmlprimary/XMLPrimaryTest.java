package com.chapter03.xmlprimary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    通过配置文件配置首选项
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
public class XMLPrimaryTest {
    @Autowired
    private Desert desert;

    @Test
    public void getCake(){
        System.out.println(desert);
    }
}
