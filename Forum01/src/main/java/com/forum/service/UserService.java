package com.forum.service;

import com.forum.dao.LoginLogDao;
import com.forum.dao.UserDao;
import com.forum.domain.LoginLog;
import com.forum.domain.User;
import com.forum.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public void save(User user){
        System.out.println("service:save");
        userDao.save(user);
    }

    public void update(User user){
        System.out.println("update user");
        userDao.update(user);
    }

    public List<User> loadAll(){
        System.out.println("service:loadAll");
        return userDao.getAll();
    }

    public void delete(int id){
        System.out.println("delete:"+id);
        userDao.deleteById(id);
    }

    public User loadUserById(int id) {
        System.out.println("load by id :"+id);
        return userDao.loadById(id);
    }

    /*
    用户登陆成功：用户登陆成功增加5积分，并且记录登陆日志
     */
    public void loginSuccess(User user){
        user.setCredit(5+user.getCredit());
        LoginLog log = new LoginLog();
        log.setUser(user);
        log.setLoginDate(new Date());
        log.setIp(user.getLastIp());  //记录登陆地址
        userDao.update(user);
        loginLogDao.save(log);
    }

    public User getUserByUserName(String username){
        System.out.println("getUserByName...");
        return userDao.getUserByUserName(username);
    }

    /*
    加锁
     */
    public void lockUser(String username) throws UserNotExistException {
        System.out.println("lock user:"+username);
        User user = userDao.getUserByUserName(username);
        if(user == null){
            throw new UserNotExistException(username);
        }
        user.setLocked(User.LOCK_USER);
        userDao.update(user);
    }

    /**
     * 解锁
     * @param username
     * @throws UserNotExistException
     */
    public void unLockUser(String username) throws UserNotExistException {
        System.out.println("unlock user:"+username);
        User user = userDao.getUserByUserName(username);
        if(user == null){
            throw new UserNotExistException(username);
        }
        user.setLocked(User.UNLOCK_USER);
        userDao.update(user);
    }

    /**
     * 查询用户的登陆信息
     * @param userId
     * @return
     */
    public List<LoginLog> getLoginLogByUserId(String userId){
        return loginLogDao.getLoginLogByUserId(userId);
    }
}
