package com.daily.service.impl;

import com.daily.dao.CommentDao;
import com.daily.entity.Comment;
import com.daily.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment getCommentByCommentId(int commentId) {
        return commentDao.getCommentByCommentId(commentId);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        return commentDao.getCommentByPostId(postId);
    }

    @Override
    public List<Comment> getCommentByUserId(int userId, int anonym) {
        //如果该评论为匿名评论
        if(anonym == 1){
            //通过解密算法得到userId
            return commentDao.getCommentByUserId(userId);
        }
        else {
            return commentDao.getCommentByUserId(userId);
        }
    }

    @Transactional
    @Override
    public boolean createComment(Comment comment) {
        //判断内容是否为空或空串
        if(comment.getCommentContent() != null && !comment.getCommentContent().equals("")) {
            //设置新增、修改日期为当前日期
            comment.setCommentCreateTime(new Date());
            comment.setCommentUpdateTime(new Date());
            //如果匿名评论
            /*
            if(comment.getAnonym() == 1) {
                //通过加密处理算法得到新的userId
            }
            */
            try {
                boolean b = commentDao.createComment(comment);
                if(b == true) {
                    return true;
                } else {
                    throw new RuntimeException("评论失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("评论失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("评论内容不能为空！");
        }
    }

    @Override
    public boolean updateComment(Comment comment) {
        //判断内容是否为空或空串
        if(comment.getCommentContent() != null && !comment.getCommentContent().equals("")) {
            //设置修改日期为当前日期
            comment.setCommentUpdateTime(new Date());
            try {
                boolean b = commentDao.updateComment(comment);
                if(b == true) {
                    return true;
                } else {
                    throw new RuntimeException("修改评论失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改评论失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("修改评论内容不能为空！");
        }
    }

    @Override
    public boolean deleteComment(int commentId) {
        try {
            boolean b = commentDao.deleteComment(commentId);
            if(b == true) {
                return true;
            } else {
                throw new RuntimeException("删除评论失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除评论失败：" + e.getMessage());
        }
    }
}
