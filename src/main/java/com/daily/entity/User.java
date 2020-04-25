package com.daily.entity;

import java.util.Date;
import java.util.zip.DataFormatException;

public class User {
    //用户ID
    private int userId;
    //用户类型（普通用户为0，管理员为1）
    private int userType;
    //用户名
    private String userName;
    //用户密码
    private String userPwd;
    //用户头像
    private String userImg;
    //用户所属地区ID
    private String areaId;
    //用户出生日期
    private Date userDate;
    //用户性别
    private String gender;
    //用户简介
    private String profile;
    //是否可用（是1，否0）
    private int state;
    //粉丝数
    private int fansNum;
    //关注数
    private int followNum;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }
}
