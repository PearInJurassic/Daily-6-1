package com.massizhi.daily.entity;

import java.util.List;

public class TimeAxis {
    //时间轴ID
    private Integer timeAxisId;
    //时间轴类型
    private String timeAxisType;
    //用户ID
    private Integer userId;

    public Integer getTimeAxisId() {
        return timeAxisId;
    }

    public void setTimeAxisId(Integer timeAxisId) {
        this.timeAxisId = timeAxisId;
    }

    public String getTimeAxisType() {
        return timeAxisType;
    }

    public void setTimeAxisType(String timeAxisType) {
        this.timeAxisType = timeAxisType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
