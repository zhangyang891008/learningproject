package com.chapter03.placeholder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
    占位符使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PlaceHolderTest {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void test(){
        System.out.println(blankDisc);
    }
}
