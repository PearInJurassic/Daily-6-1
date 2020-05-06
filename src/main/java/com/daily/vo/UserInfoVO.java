package com.daily.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    String userName;
    String userImg;
    String gender;
    String profile;
    Integer fansNum;
    Integer followNum;
    Integer postNum;
}
