/**
 * @Title: Post.java
 * @Package com.daily.entity
 * @Description: TODO
 * @author Doris
 * @date 2020年4月4日 上午11:46:18
 * @version V1.0
 */
package com.daily.entity;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @ClassName: Post
 * @Description: TODO
 * @author Doris
 * @date 2020年4月4日 上午11:46:18
 *
 */
public class Post {

    private Integer postId;

    private Date postCreateTime;

    private Date postUpdateTime;

    private Integer forwardNum;

    private Integer tipoffNum;

    private String postImg;

    private String postContent;

    private Integer anonym;

    private Integer areaId;

    private Integer userId;

    private Integer forwardPostId;

    //人气值
    @Transient
    private Integer popularity;

    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * @return the postCreateTime
     */
    public Date getPostCreateTime() {
        return postCreateTime;
    }

    /**
     * @param postCreateTime the postCreateTime to set
     */
    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    /**
     * @return the postUpdateTime
     */
    public Date getPostUpdateTime() {
        return postUpdateTime;
    }

    /**
     * @param postUpdateTime the postUpdateTime to set
     */
    public void setPostUpdateTime(Date postUpdateTime) {
        this.postUpdateTime = postUpdateTime;
    }

    /**
     * @return the forwardNum
     */
    public Integer getForwardNum() {
        return forwardNum;
    }

    /**
     * @param forwardNum the forwardNum to set
     */
    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
    }

    /**
     * @return the tipoffNum
     */
    public Integer getTipoffNum() {
        return tipoffNum;
    }

    /**
     * @param tipoffNum the tipoffNum to set
     */
    public void setTipoffNum(Integer tipoffNum) {
        this.tipoffNum = tipoffNum;
    }

    /**
     * @return the postImg
     */
    public String getPostImg() {
        return postImg;
    }

    /**
     * @param postImg the postImg to set
     */
    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    /**
     * @return the postContent
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * @param postContent the postContent to set
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    /**
     * @return the anonym
     */
    public Integer getAnonym() {
        return anonym;
    }

    /**
     * @param anonym the anonym to set
     */
    public void setAnonym(Integer anonym) {
        this.anonym = anonym;
    }

    /**
     * @return the areaId
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * @param areaId the areaId to set
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the forwardPostId
     */
    public Integer getForwardPostId() {
        return forwardPostId;
    }

    /**
     * @param forwardPostId the forwardPostId to set
     */
    public void setForwardPostId(Integer forwardPostId) {
        this.forwardPostId = forwardPostId;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
