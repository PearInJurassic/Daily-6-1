package com.daily.entity;

public class Area {
    //地区ID
    private int areaId;
    //地区名称
    private String areaName;
    //所属地区ID
    private int belongAreaId;
    //气泡数
    private int bubbleNum;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getBelongAreaId() {
        return belongAreaId;
    }

    public void setBelongAreaId(int belongAreaId) {
        this.belongAreaId = belongAreaId;
    }

    public int getBubbleNum() {
        return bubbleNum;
    }

    public void setBubbleNum(int bubbleNum) {
        this.bubbleNum = bubbleNum;
    }
}
