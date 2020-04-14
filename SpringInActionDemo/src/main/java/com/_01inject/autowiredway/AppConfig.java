package com._01inject.autowiredway;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*
通过注解配置，不依赖xml文件
 */
@Configuration
@ComponentScan
public class AppConfig {
    @Component
    public static class UserService implements IUserService {

        public void regist() {
            System.out.println("user regist");
        }
    }
}
