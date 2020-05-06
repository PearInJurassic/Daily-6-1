package com.daily.controller;

import com.daily.entity.Area;
import com.daily.entity.Comment;
import com.daily.service.CommentService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /*
     * 通过评论ID得到评论信息
     *
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/getcommentbycommentid", method = RequestMethod.GET)
    private Map<String, Object> getCommentByCommentId(int commentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Comment comment = new Comment();
        // 获取评论信息
        comment = commentService.getCommentByCommentId(commentId);
        modelMap.put("comment", comment);
        return modelMap;
    }

    /*
     * 通过帖子ID得到评论列表
     *
     * @param postId
     * @return
     */
    @RequestMapping(value = "/getcommentbypostid", method = RequestMethod.GET)
    private Map<String, Map<String, Object>> getCommentByPostId(int postId) {
        Map<String, Map<String, Object>> modelMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        List<List<Comment>> commentList = new ArrayList<List<Comment>>();
        int i = 0;
        // 获取评论列表
        commentList = commentService.getCommentByPostId(postId);
        modelMap.put("commentList", null);
        for(List<Comment> list : commentList) {
            map.put("commentList" + i++, list);
            modelMap.put("commentList", map);
        }
        return modelMap;
    }

    /*
     * 通过用户ID得到评论列表
     *
     * @param postId
     * @return
     */
    @RequestMapping(value = "/getcommentbyuserid", method = RequestMethod.GET)
    private Map<String, Object> getCommentByUserId(int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Comment> commentList = new ArrayList<Comment>();
        // 获取评论列表
        commentList = commentService.getCommentByUserId(userId);
        modelMap.put("commentList", commentList);
        return modelMap;
    }

    /*
     * 新增评论
     *
     * @param Comment
     * @return boolean
     */
    @RequestMapping(value = "/createcomment", method = RequestMethod.POST)
    private Map<String, Object> createComment(@RequestBody Comment comment) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 新增评论
        modelMap.put("success", commentService.createComment(comment));
        return modelMap;
    }

    /*
     * 修改评论
     *
     * @param Comment
     * @return boolean
     */
    @RequestMapping(value = "/updatecomment", method = RequestMethod.POST)
    private Map<String, Object> updateComment(@RequestBody Comment comment) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改评论
        modelMap.put("success", commentService.updateComment(comment));
        return modelMap;
    }

    /*
     * 删除评论
     *
     * @param Comment
     * @return boolean
     */
    @RequestMapping(value = "/deletecomment", method = RequestMethod.GET)
    private Map<String, Object> deleteComment(int commentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 删除评论
        modelMap.put("success", commentService.deleteComment(commentId));
        return modelMap;
    }
}
