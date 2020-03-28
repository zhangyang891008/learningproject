package com.forum.dao;

import com.forum.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private HibernateTemplate hibernateTemplate;

    public void save(LoginLog loginLog){
        System.out.println("save LoginLog...");
        hibernateTemplate.save(loginLog);
    }

}
