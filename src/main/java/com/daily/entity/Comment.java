package com.daily.entity;

import java.util.Date;

public class Comment {
    //评论ID
    private int commentId;
    //评论内容
    private String commentContent;
    //评论时间
    private Date commentCreateTime;
    //评论修改时间
    private Date commentUpdateTime;
    //被评论帖子ID
    private int postId;
    //用户ID
    private int userId;
    //是否匿名评论（是1，否0）
    private int anonym;
    //顶层评论ID（0代表顶层）
    private int belongCommentId;
    //回复评论ID
    private int replyCommentId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Date getCommentUpdateTime() {
        return commentUpdateTime;
    }

    public void setCommentUpdateTime(Date commentUpdateTime) {
        this.commentUpdateTime = commentUpdateTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAnonym() {
        return anonym;
    }

    public void setAnonym(int anonym) {
        this.anonym = anonym;
    }

    public int getBelongCommentId() {
        return belongCommentId;
    }

    public void setBelongCommentId(int belongCommentId) {
        this.belongCommentId = belongCommentId;
    }

    public int getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(int replyCommentId) {
        this.replyCommentId = replyCommentId;
    }
}