package com.forum.service;

import com.forum.dao.BoardDao;
import com.forum.dao.PostDao;
import com.forum.dao.TopicDao;
import com.forum.domain.Board;
import com.forum.domain.Post;
import com.forum.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private PostDao postDao;

    //++++++++++板块方法+++++++++++

    public void saveBoard(Board board) {
        boardDao.save(board);
    }

    public List<Board> listAllBoards(){
        return boardDao.loadAll();
    }

    public void deleteBoardById(int boardId) {
        boardDao.delete(boardId);
    }

    public Board getBoardById(int boardId){
        return  boardDao.loadById(boardId);
    }

    //+++++++++++帖子方法+++++++++++
    public void saveTopic(Topic topic){
        topicDao.save(topic);
    }

    public List<Topic> getTopicsByBoardId(int boardId) {
        return topicDao.loadByBoardId(boardId);
    }

    public void setTopicDigest(int topicId){
        Topic topic = topicDao.loadById(topicId);
        topic.setDigest(Topic.DIGEST_TOPIC);
        topicDao.update(topic);
    }

    public void setTopicUnDigest(int topicId){
        Topic topic = topicDao.loadById(topicId);
        topic.setDigest(Topic.NOT_DIGEST_TOPIC);
        topicDao.update(topic);
    }


    //+++++++++回帖+++++++++

    public List<Post> getPostByTopicId(int topicId){
        return postDao.loadByTopicId(topicId);
    }

    public void savePost(Post post){
        postDao.save(post);
    }

    public Topic getTopicById(int topicId) {
        return topicDao.loadById(topicId);
    }
}
