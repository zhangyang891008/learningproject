package com.zy.mybatis.dao;

import com.zy.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testUserById(){
        UserDao mapper = sqlSessionFactory.openSession().getMapper(UserDao.class);
        User user = mapper.selectById(Integer.valueOf(3));
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUserName("guangle2");
        user.setAddress("neu2");
        user.setPassword("123456");
        mapper.insert(user);
        sqlSession.commit();
        System.out.println("finish");
    }

    @Test
    public void testLoadAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.loadAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("finish");
    }

}
