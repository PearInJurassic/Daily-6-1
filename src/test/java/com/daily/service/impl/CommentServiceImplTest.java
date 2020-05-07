package com.daily.service.impl;

import com.daily.entity.Comment;
import com.daily.service.CommentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;


    @Test
    @Ignore
    public void getCommentByCommentId() {
        Comment comment = commentService.getCommentByCommentId(1);
        assertEquals(1,comment.getPostId());
    }

    @Test
    @Ignore
    public void getCommentByPostId() {
        List<List<Comment>> commentList = commentService.getCommentByPostId(1);
        //assertEquals(2,commentList.size());
        for(List<Comment> list : commentList) {
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).getCommentContent());
            }
        }

    }

    @Test
    @Ignore
    public void getCommentByUserId() {
        List<Comment> commentList = commentService.getCommentByUserId(2);
        assertEquals(3,commentList.size());
    }

    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setCommentContent("测试新增方法");
        comment.setPostId(1);
        comment.setUserId(10);
        comment.setAnonym(0);
        comment.setReplyCommentId(0);
        assertEquals(true,commentService.createComment(comment));
    }

    @Test
    @Ignore
    public void updateComment() {
        Comment comment = commentService.getCommentByCommentId(6);
        comment.setCommentContent("");
        assertEquals(true, commentService.updateComment(comment));
    }

    @Test
    @Ignore
    public void deleteComment() {
        assertEquals(true, commentService.deleteComment(11));
    }

    @Test
    @Ignore
    public void getCommentNumByPostId() {
        assertEquals(2,commentService.getCommentNumByPostId(2));
    }
}