package com.massizhi.daily.entity;

import java.util.Date;
//增加了用户地区名
public class UserExpand {
    private User user;
    //用户所属地区名
    private String areaName;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
