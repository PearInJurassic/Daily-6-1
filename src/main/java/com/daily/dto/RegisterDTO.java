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

}
