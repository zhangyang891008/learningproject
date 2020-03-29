package com.forum.service;

import com.forum.dao.BoardDao;
import com.forum.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public void save(Board board) {
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
}
