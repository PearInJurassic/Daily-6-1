package com.daily.entity;

import java.util.Date;

public class Post {
    //帖子ID
    private int postId;
    //发帖时间
    private Date postCreateTime;
    //更新时间
    private Date postUpdateTime;
    //点赞数
    private int likeNum;
    //转发数
    private int forwardNum;
    //评论数
    private int commentNum;
    //举报数
    private int tipoffNum;
    //帖子图片
    private String postImg;
    //帖子内容
    private String postContent;
    //是否匿名（是1，否0）
    private int anonym;
    //帖子所属地区ID
    private int areaId;
    //发帖人ID
    private int userId;
    //该帖是否为转发帖子（是1，否0）
    private int forward;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public Date getPostUpdateTime() {
        return postUpdateTime;
    }

    public void setPostUpdateTime(Date postUpdateTime) {
        this.postUpdateTime = postUpdateTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(int forwardNum) {
        this.forwardNum = forwardNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getTipoffNum() {
        return tipoffNum;
    }

    public void setTipoffNum(int tipoffNum) {
        this.tipoffNum = tipoffNum;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getAnonym() {
        return anonym;
    }

    public void setAnonym(int anonym) {
        this.anonym = anonym;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }
}
