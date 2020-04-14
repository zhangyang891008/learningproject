package com.forum.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.forum.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserDao {

    @Autowired
    @Qualifier("dataSource")
    private DruidDataSource dataSource;

    public void save(User user){
        /*
        dataSource.setPassword("Zy891008!");
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://node1:3306/sampledb?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");*/
        System.out.println("saving user....");
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"zhangsan");
            preparedStatement.setString(3,"password");
            preparedStatement.setInt(4,1);
            preparedStatement.setInt(5,1);
            preparedStatement.setInt(6,123);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
