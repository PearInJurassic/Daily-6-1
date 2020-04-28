package com.massizhi.daily.entity;

import java.util.List;

public class TimeAxis {
    //时间轴ID
    private int timeAxisId;
    //时间轴类型
    private String timeAxisType;
    //用户ID
    private int userId;

    public int getTimeAxisId() {
        return timeAxisId;
    }

    public void setTimeAxisId(int timeAxisId) {
        this.timeAxisId = timeAxisId;
    }

    public String getTimeAxisType() {
        return timeAxisType;
    }

    public void setTimeAxisType(String timeAxisType) {
        this.timeAxisType = timeAxisType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
