package com.daily.dao;

import com.daily.entity.Area;

import java.util.List;

public interface AreaDao {
    /*
     * 通过地区ID得到地区信息
     *
     * @param areaId
     * @return Area
     */
    Area getAreaById(int areaId);

    /*
     * 通过地区名称得到地区信息
     *
     * @param areaName
     * @return Area
     */
    Area getAreaByName(String areaName);

    /*
     * 通过所属地区ID得到地区信息列表
     *
     * @param belongAreaId
     * @return List<Area>
     */
    List<Area> getAreaListByBelongAreaId(int belongAreaId);

    /*
     * 更新地区气泡数
     *
     * @param Area
     * @return boolean
     */
    boolean updateBubbleNum(Area area);
}
