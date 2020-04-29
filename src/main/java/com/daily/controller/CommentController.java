package com.daily.controller;

import com.daily.entity.Area;
import com.daily.entity.Comment;
import com.daily.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
        // 获取地区信息
        comment = commentService.getCommentByCommentId(commentId);
        modelMap.put("area", comment);
        return modelMap;
    }
}
