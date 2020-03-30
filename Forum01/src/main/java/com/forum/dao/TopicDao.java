package com.forum.dao;

import com.forum.domain.Topic;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(Topic topic){
        System.out.println("topic save...");
        hibernateTemplate.save(topic);
    }

    public void update(Topic topic){
        System.out.println("topic update...");
        hibernateTemplate.update(topic);
    }

    public List<Topic> loadByBoardId(int boardId) {
        System.out.println("load topics by boardId:"+boardId);
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        NativeQuery sqlQuery = session.createSQLQuery("select * from t_topic where board_id ='" + boardId + "';").addEntity(Topic.class);
        List<Topic> list = sqlQuery.list();
        return list;
    }

    public Topic loadById(int topicId){
        System.out.println("load topics by topicId:"+ topicId);
        Topic topic = hibernateTemplate.load(Topic.class, topicId);
        return topic;
    }
}
