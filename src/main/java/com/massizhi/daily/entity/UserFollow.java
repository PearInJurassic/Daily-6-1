package com.massizhi.daily.entity;

import java.util.Date;

public class UserFollow {
    //用户关注ID
    private Integer userFollowId;
    //用户ID
    private Integer userId;
    //关注用户的ID
    private Integer followId;
    //关注时间
    private Date followTime;

    public Integer getUserFollowId() {
        return userFollowId;
    }

    public void setUserFollowId(Integer userFollowId) {
        this.userFollowId = userFollowId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}
