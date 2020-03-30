package com.forum.controller;

import com.forum.domain.Board;
import com.forum.domain.User;
import com.forum.exception.UserNotExistException;
import com.forum.service.BoardService;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        boardService.saveBoard(board);
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

    @RequestMapping("/deleteBoardManager")
    public String delBoardManager(String username,String boardId,Model model){
        User manager = userService.getUserByUserName(username);
        if(manager==null){
            model.addAttribute("msg","user not exist can not add board!");
            return "error";
        }
        Board board = boardService.getBoardById(Integer.parseInt(boardId));
        Set<Board> manBoards = manager.getManBoards();
        if(manBoards==null){
            model.addAttribute("msg",username+" have not management of board:"+boardId);
            return "error";
        }

        for (Board manBoard : manBoards) {
            if(Integer.compare(Integer.parseInt(boardId), manBoard.getBoardId())==0){
                manager.getManBoards().remove(manBoard);
                userService.update(manager);
                model.addAttribute("msg",username+" remove board manager succcess!"+boardId);
                return "success";
            }
        }
        model.addAttribute("msg",username+" have not management of board:"+boardId);
        return "error";
    }

    @RequestMapping("/unlockUser")
    public String unlockUser(String username, Model model){
        try {
            userService.unLockUser(username);
            model.addAttribute("msg","unlock user success!");
            return "success";
        } catch (UserNotExistException e) {
            e.printStackTrace();
            model.addAttribute("msg",e.getMessage());
            return "error";
        }

    }

    @RequestMapping("/lockUser")
    public String lockUser(String username,Model model){
        try {
            userService.lockUser(username);
            model.addAttribute("msg","lock user success");
            return "success";
        } catch (UserNotExistException e) {
            e.printStackTrace();
            model.addAttribute("msg",e.getMessage());
            return "error";
        }
    }

    @RequestMapping("/toModifyPassword/{userId}")
    public String toModifyPassword(@PathVariable String userId,Model model){
        if(userId==null){
            model.addAttribute("error","userId is null");
        }
        model.addAttribute("userId",userId);
        return "user/modifyPassword";
    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(User user,String newPassword,Model model){
        User dbUser = userService.loadUserById(user.getUserId());
        if(!dbUser.getPassword().equals(user.getPassword())){
            model.addAttribute("msg","old password is not correct!");
            return "error";
        }
        if(user.getPassword().equals(newPassword)){
            model.addAttribute("msg","new password is same with the old one!");
            return "error";
        }
        dbUser.setPassword(newPassword);
        userService.update(dbUser);
        model.addAttribute("msg","modify password success");
        return "success";

    }


    //+++++++++ topic ++++++++++

    @RequestMapping("/setDigest/{topicId}")
    public String setTopicDigest(@PathVariable String topicId,Model model){
        boardService.setTopicDigest(Integer.valueOf(topicId));
        model.addAttribute("msg","set topic digest success:"+topicId);
        return "success";
    }

    @RequestMapping("/setUnDigest/{topicId}")
    public String setTopicUnDigest(@PathVariable String topicId,Model model){
        boardService.setTopicUnDigest(Integer.valueOf(topicId));
        model.addAttribute("msg","set untopic digest success:"+topicId);
        return "success";
    }
}
