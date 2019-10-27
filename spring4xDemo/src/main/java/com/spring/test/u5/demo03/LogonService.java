package com.spring.test.u5.demo03;

public class LogonService {
    private  UserDao userDao;
    private LogDao logDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public LogonService(){

    }
}
