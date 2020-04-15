package com.chapter03.condition;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
测试通过条件判断是否需要创建bean
@Conditional
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {
    @Autowired
    private MagicBean bean;

    @Before
    public void setProperty(){
        System.setProperty("magic","test");
    }

    @Test
    public void getMagicBean(){
        System.out.println(bean);
    }
}
