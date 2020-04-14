package com._02xml.xmlway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
通过配置文件定义bean
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PersonServiceTest {

    @Autowired
    private IPersonService personService;

    @Autowired
    private EmpService empService;

    @Test
    public void test(){
        personService.working();
    }

    @Test
    public void getEmp(){
        Emp emp = empService.getEmp();
        System.out.println(emp);
    }


    @Test
    public void getName(){
        String name = empService.getName();
        System.out.println(name);
    }
}
