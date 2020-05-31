package com.daily.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminAction {
    //记录id
    private Integer actionId;
    //操作类型 0为冻结 1为解冻
    private Integer type;
    //管理员id
    private Integer adminId;
    //被冻结/解冻的用户id
    private Integer userId;
    //冻结/解冻发生的时间
    private Date actionDate;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
