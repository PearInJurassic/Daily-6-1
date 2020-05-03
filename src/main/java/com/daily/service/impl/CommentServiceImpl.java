package com.daily.service.impl;

import com.daily.dao.CommentDao;
import com.daily.entity.Comment;
import com.daily.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<List<Comment>> getCommentByPostId(int postId) {
        //获得最顶层的评论列表
        List<Comment> list = commentDao.getCommentByPostId(postId);
        //存储以最顶层评论包含以下的评论结构
        List<Comment> commentList1 = new ArrayList<>();
        //存储所有评论列表
        List<List<Comment>> commentList = new ArrayList<>();
        int i = 0;
        for(Comment comment : list) {
            //顶层评论加入list头部
            commentList1.add(list.get(i++));
            //添加下层评论
            commentList1.addAll(commentDao.getCommentByBelongCommentId(comment.getCommentId()));
            //该评论包含以下评论加入所有评论别表
            commentList.add(commentList1);
            commentList1 = new ArrayList<>();
        }
        return commentList;
    }

    @Override
    public List<Comment> getCommentByUserId(int userId) {
        return commentDao.getCommentByUserId(userId);
    }

    @Transactional
    @Override
    public boolean createComment(Comment comment) {
        //判断内容是否为空或空串
        if(comment.getCommentContent() != null && !comment.getCommentContent().equals("")) {
            //设置新增、修改日期为当前日期
            comment.setCommentCreateTime(new Date());
            comment.setCommentUpdateTime(new Date());
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

    @Override
    public int getCommentNumByPostId(int postId) {
        return commentDao.getCommentByPostId(postId).size();
    }

}
