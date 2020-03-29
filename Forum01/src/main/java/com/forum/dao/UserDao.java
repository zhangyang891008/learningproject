package com.forum.dao;

import com.forum.domain.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private HibernateTemplate hibernateTemplate;

    public User loadById(int id){
        System.out.println("load by id ....."+id);
        return hibernateTemplate.load(User.class, id);
    }

    public void save(User user){
        System.out.println("saving user....");
        try {
            hibernateTemplate.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll(){
        System.out.println("getAll user....");
        List<User> users = hibernateTemplate.loadAll(User.class);
        return users;
    }

    public void deleteById(int id){
        User user = new User();
        user.setUserId(id);
        hibernateTemplate.delete(user);
    }

    public User getUserByUserName(String userName){
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        NativeQuery sqlQuery = session.createSQLQuery("select * from t_user where user_name ='" + userName + "';").addEntity(User.class);
        List<User> list = sqlQuery.list();
        User user = null;
        if(list.size()>0){
            user = list.get(0);
        }

        System.out.println("getUserByUserName"+list.get(0));
        return user;
    }

    public void update(User user) {
        hibernateTemplate.update(user);
    }
}
