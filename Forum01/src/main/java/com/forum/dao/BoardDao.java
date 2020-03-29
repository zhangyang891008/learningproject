package com.forum.dao;

import com.forum.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private HibernateTemplate hibernateTemplate;

    public void save(Board board){
        System.out.println("board save....");
        hibernateTemplate.save(board);
    }

    public void delete(int boardId){
        System.out.println("delete board..."+boardId);
        Board board = new Board();
        board.setBoardId(boardId);
        hibernateTemplate.delete(board);
    }

    public void update(Board board){
        System.out.println("update Board....");
        hibernateTemplate.update(board);
    }

    public List<Board> loadAll(){
        List<Board> boards = null;
        try{
            System.out.println("load all boards");
            boards = hibernateTemplate.loadAll(Board.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return boards;
    }

    public Board loadById(int boardId) {
        System.out.println("loadBoard by id:"+boardId);
       return hibernateTemplate.load(Board.class,boardId);
    }
}
