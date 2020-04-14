package com._04xmlbean.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext04.xml")
public class XMLBeanTest {

    @Autowired
    private PersonDoc personDoc;

    @Test
    public void getPersonDoc(){
        System.out.println(personDoc);
    }
}
