package com.daily.dao;

import com.daily.entity.TimeAxis;

public interface TimeAxisDao {
    /*
     * 通过时间轴ID得到时间轴类型
     *
     * @param timeAxisId
     * @return TimeAxis
     */
    TimeAxis getTimeAxisById(int timeAxisId);

    /*
     * 通过时间轴ID得到时间轴类型
     *
     * @param timeAxisId
     * @return TimeAxis
     */
    TimeAxis getTimeAxisByType(int timeAxisType);
}
