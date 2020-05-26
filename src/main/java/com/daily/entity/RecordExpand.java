package com.daily.entity;
//增加了地区名
public class RecordExpand {
    private Record record;
    //动态所属地区名
    private String areaName;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
