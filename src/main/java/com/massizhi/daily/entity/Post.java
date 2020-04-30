package com.massizhi.daily.entity;

import java.util.Date;

public class Post {
    //帖子ID
    private Integer postId;
    //帖子创建时间
    private Date postCreateTime;
    //帖子更新时间
    private Date postUpdateTime;
    //点赞数
    private Integer likeNum;
    //转发数
    private Integer forwardNum;
    //评论数
    private Integer commentNum;
    //举报数
    private Integer tipoffNum;
    //帖子图片URL
    private String postImg;
    //帖子内容
    private String postContent;
    //是否匿名（是1，否0）
    private Integer anonym;
    //帖子所属地区ID
    private Integer areaId;
    //发帖人ID
    private Integer userId;
    //该帖是否为转发帖子（是1，否0）
    private Integer forward;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
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

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getTipoffNum() {
        return tipoffNum;
    }

    public void setTipoffNum(Integer tipoffNum) {
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

    public Integer getAnonym() {
        return anonym;
    }

    public void setAnonym(Integer anonym) {
        this.anonym = anonym;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getForward() {
        return forward;
    }

    public void setForward(Integer forward) {
        this.forward = forward;
    }
}
