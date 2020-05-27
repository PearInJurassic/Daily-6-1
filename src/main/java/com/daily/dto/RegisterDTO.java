package com.daily.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    //用户类型（普通用户为0，管理员为1）
    private Integer userType;
    //用户邮箱
    private String email;
    //用户名
    private String userName;
    //用户密码
    private String userPwd;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
