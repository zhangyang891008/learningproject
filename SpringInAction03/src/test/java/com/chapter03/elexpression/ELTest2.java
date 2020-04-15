package com.chapter03.elexpression;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ELTest2 {

    @Autowired
    private Environment env;

    @Autowired
    private ConfigurableBeanFactory factory;

    @Test
    public void test(){
        String title = env.getProperty("disc.title");

        BlankDisc bean = factory.getBean(BlankDisc.class);
        System.out.println(bean);
    }
}
