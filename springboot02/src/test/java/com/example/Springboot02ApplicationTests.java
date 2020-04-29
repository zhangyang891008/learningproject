package com.example;

import com.example.entity.Emp;
import com.example.entity.Shopping;
import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
    1.测试配置文件中的属性装配到不同类型的字段中，包括Duration DataSize等。
    2.宽松绑定empNo -> emp_no 、emp-no 、EMP_NO、 empno 、empNo 这几种方式都可以绑定
    3.自定义Converter：WeightConverter,通过@Configuration类创建bean并通过注解@ConfigurationPropertiesBinding绑定
 */
@SpringBootTest
class Springboot02ApplicationTests{

    @Autowired
    private Student student;

    @Autowired
    private Emp emp;

    @Autowired
    private Shopping shopping;

    @Test
    void contextLoads() {
        System.out.println(emp);
        System.out.println(student);
        System.out.println(shopping);
        System.out.println(student.getSleep().getSeconds());
    }



}
