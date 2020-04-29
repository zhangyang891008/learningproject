package com.example;

import com.example.entity.Cat;
import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/*
    @EnableConfigurationProperties(Student.class)的功能测试：
        在没有@Component注解的情况下 Student类因为有上面的注解进行声明，所以可以被识别到，但是Cat因为没有配置到上面注解中，所以扫描不到。
        如果加上注解@Component注解，两个类都可以被注入


在spring-boot中，

1、如果@ConfigurationProperties所注的类可以被springboot扫描并添加进容器中作为bean（比如使用@Component等注解，或者配置扫描该类所在包等手段），那么spring容器会自动使该类上的@ConfigurationProperties生效，创建一个该类的实例，然后把对应配置属性绑定进该实例，再把该实例作为bean添加进spring容器。

2、如果该类只使用了@ConfigurationProperties注解，然后该类没有在扫描路径下或者没有使用@Component等注解，导致无法被扫描为bean，那么就必须在配置类上使用@EnableConfigurationProperties注解去指定这个类，这个时候就会让该类上的@ConfigurationProperties生效，然后作为bean添加进spring容器中

3.在javaconfig中@ConfigurationProperties与@Bean一起用，也是把配置文件中的属性注入该@Bean对应的要添加到容器中的bean实例中。
————————————————
原文链接：https://blog.csdn.net/qq_36951116/article/details/82927426

 */
@SpringBootTest
@EnableConfigurationProperties(Student.class)
class Springboot03ApplicationTests {

    @Autowired
    private Student student;

    //@Autowired
   // private Cat cat;
    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        System.out.println(student);
        //System.out.println(cat);
        System.out.println(environment);
    }

}
