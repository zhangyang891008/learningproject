package com.forum.dao;

import com.forum.domain.Post;
import com.forum.domain.Topic;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public class PostDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(Post post){
        System.out.println("save post");
        hibernateTemplate.save(post);
    }

    public void update(Topic topic){
        System.out.println("update post");
        hibernateTemplate.update(topic);
    }

    public List<Post> loadByTopicId(int topicId){
        System.out.println("load post by topicId:"+topicId);
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        NativeQuery sqlQuery = session.createSQLQuery("select * from t_post where topic_id='" + topicId + "';").addEntity(Post.class);
        List<Post> list = sqlQuery.list();
        return list;
    }
}

