package com.chapter03.profile;

public class MyEnv {
    private String env;

    public MyEnv(String env){
        this.env = env;
    }

    @Override
    public String toString() {
        return env;
    }
}
