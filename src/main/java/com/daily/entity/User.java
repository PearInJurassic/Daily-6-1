package com.daily.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    //用户ID
    private Integer userId;
    //用户类型（普通用户为0，管理员为1）
    private Integer userType;
    //用户名
    private String userName;
    //用户密码
    private String userPwd;
    //用户头像URL
    private String userImg;
    //用户所属地区ID
    private Integer areaId;
    //用户出生日期
    private Date userDate;
    //用户性别
    private String gender;
    //用户简介
    private String profile;
    //是否可用（是1，否0）
    private Integer state;
    //粉丝数
    private Integer fansNum;
    //关注数
    private Integer followNum;
    //邮箱
    private String email;

}
