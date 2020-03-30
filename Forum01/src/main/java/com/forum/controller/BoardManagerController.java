package com.forum.controller;

import com.forum.cons.CommonConstant;
import com.forum.domain.Board;
import com.forum.domain.Post;
import com.forum.domain.Topic;
import com.forum.domain.User;
import com.forum.service.BoardService;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardManagerController {
    @Autowired
    private UserService userService;
    @Autowired
    private BoardService boardService;

    @RequestMapping("/toAddTopic")
    public String toAddTopic(HttpServletRequest request){
        List<Board> boards = boardService.listAllBoards();
        request.setAttribute("boards",boards);
        return "topic/addTopic";
    }


    @RequestMapping("/addTopic")
    public String addTopic(HttpSession session, Topic topic, Model model){
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if(user==null){
            model.addAttribute("msg","please login!");
            return "error";
        }
        topic.setUser(user);
        boardService.saveTopic(topic);
        //更新数量统计
        Board board = boardService.getBoardById(topic.getBoardId());
        board.setTopicNum(board.getTopicNum()+1);
        boardService.saveBoard(board);
        model.addAttribute("msg","add topic success");
        return "success";
    }

    @RequestMapping("/listTopics/{boardId}")
    public String listTopics(@PathVariable String boardId,Model model){
        List<Topic> topics = boardService.getTopicsByBoardId(Integer.parseInt(boardId));
        model.addAttribute("topics",topics);
        return "topic/list";
    }

    @RequestMapping("/listPostByTopicId/{topicId}")
    public String getPostsByTopicId(@PathVariable String topicId,Model model){
        Topic topic = boardService.getTopicById(Integer.valueOf(topicId));
        List<Post> posts = boardService.getPostByTopicId(Integer.valueOf(topicId));
        model.addAttribute("topic",topic);
        model.addAttribute("posts",posts);
        return "post/list";
    }

    @RequestMapping("/toAddPost")
    public String toAddPost(HttpSession session,String boardId, String topicId,Model model){
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if(user == null){
            model.addAttribute("msg","please login before add post!");
            return "error";
        }

        model.addAttribute("topicId",topicId);
        model.addAttribute("boardId",boardId);
        return "post/addPost";
    }

    @RequestMapping("/addPost")
    public String addPost(HttpSession session, Post post,String topicId,Model model){
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        Topic topic = boardService.getTopicById(Integer.valueOf(topicId));
        topic.setReplies(topic.getReplies()+1);
        post.setTopic(topic);
        post.setUser(user);

        boardService.savePost(post);
        boardService.saveTopic(topic);
        model.addAttribute("msg","add post success!");
        return "success";
    }

}
