package com._02xml.xmlway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 测试通过配置文件命名空间util:properties配置属性的读取
 */
@Component
public class EmpService {

    @Value("#{prop}")
    private Properties props;

    @Value("#{prop['name']}")
    private String name;

    public Emp getEmp(){
        Emp emp = new Emp();
        emp.setName(props.getProperty("name"));
        emp.setAge(Integer.valueOf(props.getProperty("age")));
        emp.setAddress(props.getProperty("address"));
        //System.out.println(emp);
        return emp;
    }

    public String getName(){
        return name;
    }

}
