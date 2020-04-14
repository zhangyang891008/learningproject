package com._01inject.autowiredway;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {
    public void regist() {
        System.out.println("regist");
    }
}
