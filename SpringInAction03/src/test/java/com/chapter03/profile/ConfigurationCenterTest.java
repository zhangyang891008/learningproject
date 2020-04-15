package com.chapter03.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
激活不同profile
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationCenter.class)
@ActiveProfiles("dev")
public class ConfigurationCenterTest {
    @Autowired
    private MyEnv env;

    @Test
    public void getEnv(){
        System.out.println(env);
    }
}
