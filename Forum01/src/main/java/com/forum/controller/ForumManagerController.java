package com.forum.controller;

import com.forum.dao.BoardDao;
import com.forum.domain.Board;
import com.forum.domain.User;
import com.forum.service.BoardService;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ForumManagerController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addBoard",method = RequestMethod.POST)
    public String addBoard(Board board, Model model){
        boardService.save(board);
        model.addAttribute("msg","save board success!");
        return "success";
    }

    @RequestMapping("/listBoards")
    public String listAllBoards(Model model){
        List<Board> boards = boardService.listAllBoards();
        model.addAttribute("boards",boards);
        return "board/list";
    }

    @RequestMapping("/deleteBoard")
    public String deleteBoard(int boardId,Model model){
        boardService.deleteBoardById(boardId);
        model.addAttribute("msg","board delete success:"+ boardId);
        return "success";
    }

    @RequestMapping("/addBoardManager")
    public String setBoardManager(String username,String boardId,Model model){
        User manager = userService.getUserByUserName(username);
        if(manager==null){
            model.addAttribute("msg","user not exist can not add board!");
            return "error";
        }
        Board board = boardService.getBoardById(Integer.parseInt(boardId));
        Set<Board> manBoards = manager.getManBoards();
        if(manBoards==null){
            manBoards = new HashSet<Board>();
        }
        manBoards.add(board);
        manager.setManBoards(manBoards);
        userService.update(manager);
        model.addAttribute("msg","add board manager succcess!");
        return "success";
    }
}
