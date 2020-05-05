package com.massizhi.daily.entity;

import java.util.Date;

public class Record {
    //动态ID
    private Integer recordId;
    //动态图片URL
    private String recordImg;
    //动态内容
    private String recordContent;
    //动态创建时间
    private Date recordCreateTime;
    //动态修改时间
    private Date recordUpdateTime;
    //动态所属时间轴类型
    private String timeAxisType;
    //动态所属地区ID
    private Integer areaId;
    //联系的帖子ID
    private Integer postId;
    //用户ID
    private Integer userId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
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

    public String getTimeAxisType() {
        return timeAxisType;
    }

    public void setTimeAxisType(String timeAxisType) {
        this.timeAxisType = timeAxisType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}