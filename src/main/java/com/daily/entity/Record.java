package com.daily.entity;

import java.util.Date;

public class Record {
    //动态ID
    private int recordId;
    //动态图片
    private String recordImg;
    //动态内容
    private String recordContent;
    //动态创建时间
    private Date recordCreateTime;
    //动态修改时间
    private Date recordUpdateTime;
    //动态所属时间轴ID
    private int timeAxisId;
    //动态所属地区ID
    private int areaId;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordImg() {
        return recordImg;
    }

    public void setRecordImg(String recordImg) {
        this.recordImg = recordImg;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public Date getRecordCreateTime() {
        return recordCreateTime;
    }

    public void setRecordCreateTime(Date recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    public Date getRecordUpdateTime() {
        return recordUpdateTime;
    }

    public void setRecordUpdateTime(Date recordUpdateTime) {
        this.recordUpdateTime = recordUpdateTime;
    }

    public int getTimeAxisId() {
        return timeAxisId;
    }

    public void setTimeAxisId(int timeAxisId) {
        this.timeAxisId = timeAxisId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
