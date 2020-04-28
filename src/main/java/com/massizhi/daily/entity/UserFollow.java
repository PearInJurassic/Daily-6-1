package com.massizhi.daily.entity;

import java.util.Date;

public class UserFollow {
    //用户关注ID
    private int userFollowId;
    //用户ID
    private int userId;
    //关注用户的ID
    private int followId;
    //关注时间
    private Date followTime;

    public int getUserFollowId() {
        return userFollowId;
    }

    public void setUserFollowId(int userFollowId) {
        this.userFollowId = userFollowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}
