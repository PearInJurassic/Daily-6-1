package com.daily.dao;

import com.daily.entity.Comment;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;


    @Test
    @Ignore
    public void getCommentByCommentId() {
        Comment comment = commentDao.getCommentByCommentId(1);
        assertEquals(1,comment.getBelongCommentId());
    }

    @Test
    @Ignore
    public void getCommentByPostId() {
        List<Comment> commentList = commentDao.getCommentByPostId(1);
        assertEquals(2,commentList.size());
    }

    @Test
    @Ignore
    public void getCommentByUserId() {
        List<Comment> commentList = commentDao.getCommentByUserId(2);
        assertEquals(2,commentList.size());
    }

    @Test
    @Ignore
    public void createComment() {
        Comment comment = new Comment();
        comment.setCommentContent("测试回复");
        comment.setCommentCreateTime(new Date());
        comment.setCommentUpdateTime(new Date());
        comment.setPostId(1);
        comment.setUserId(2);
        comment.setAnonym(0);
        comment.setBelongCommentId(1);
        comment.setReplyCommentId(11);
        assertEquals(true,commentDao.createComment(comment));
    }

    @Test
    @Ignore
    public void updateComment() {
        Comment comment = commentDao.getCommentByCommentId(6);
        comment.setCommentContent("更新");
        comment.setCommentUpdateTime(new Date());
        assertEquals(true, commentDao.updateComment(comment));
    }

    @Test
    @Ignore
    public void deleteComment() {
        assertEquals(true, commentDao.deleteComment(11));
    }

    @Test
    @Ignore
    public void getCommentByBelongCommentId() {
        List<Comment> commentList = commentDao.getCommentByBelongCommentId(0);
        assertEquals(5,commentList.size());
    }

    @Test
    @Ignore
    public void getCommentByReplyCommentId() {
        List<Comment> commentList = commentDao.getCommentByReplyCommentId(0);
        assertEquals(6,commentList.size());
    }

    @Test
    public void getCommentCountByPostId() {
        assertEquals(6,commentDao.getCommentNumByPostId(1));
    }
}