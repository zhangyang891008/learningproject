package com._03javabean.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
测试通过java代码创建bean,通过@Bean注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com._03javabean.test.JavaBean.class)
public class CatTest {

    @Autowired
    private Cat cat;

    @Test
    public void getCat(){
        System.out.println(cat);
    }
}
