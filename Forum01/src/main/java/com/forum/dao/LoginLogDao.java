package com.forum.dao;

import com.forum.domain.LoginLog;
import com.forum.domain.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginLogDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private HibernateTemplate hibernateTemplate;

    public void save(LoginLog loginLog){
        System.out.println("save LoginLog...");
        hibernateTemplate.save(loginLog);
    }

    public List<LoginLog> getLoginLogByUserId(String userId){
        System.out.println("get LoginLogByUserId...");
        Session currentSession = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query<LoginLog> query = currentSession.createSQLQuery("select * from t_login_log where user_id ='" + userId + "';").addEntity(LoginLog.class);
        List<LoginLog> list = query.list();
        System.out.println(list);
        return list;
    }

}
