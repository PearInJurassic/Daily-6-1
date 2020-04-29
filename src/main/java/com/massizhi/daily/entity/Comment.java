package com.massizhi.daily.entity;

import java.util.Date;

public class Comment {
    //评论ID
    private Integer commentId;
    //评论内容
    private String commentContent;
    //评论创建时间
    private Date commentCreateTime;
    //评论修改时间
    private Date commentUpdateTime;
    //被评论帖子ID
    private Integer postId;
    //用户ID
    private Integer userId;
    //是否匿名评论（是1，否0）
    private Integer anonym;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnonym() {
        return anonym;
    }

    public void setAnonym(Integer anonym) {
        this.anonym = anonym;
    }
}
