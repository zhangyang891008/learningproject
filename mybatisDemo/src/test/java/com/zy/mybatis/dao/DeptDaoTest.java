package com.zy.mybatis.dao;

import com.zy.mybatis.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class DeptDaoTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void insertTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        Dept dept = new Dept();
        dept.setDeptName("sales");
        dept.setLocation("floor1");
        mapper.insert(dept);
        sqlSession.commit();
        System.out.println("insert success");
        sqlSession.close();
    }

    @Test
    public void loadByIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        Dept dept = mapper.loadById(Integer.valueOf(1));
        System.out.println(dept);
        sqlSession.close();
    }
}
