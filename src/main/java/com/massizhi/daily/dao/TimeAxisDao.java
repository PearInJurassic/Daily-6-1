package com.massizhi.daily.dao;

public interface TimeAxisDao {
    /*
     * 通过时间轴ID得到时间轴名称
     *
     * @param timeAxisId
     * @return String
     */
    String getTimeAxisTypeById(int timeAxisId);
}
