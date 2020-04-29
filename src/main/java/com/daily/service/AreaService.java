package com.daily.service;

import com.daily.entity.Area;

import java.util.List;

public interface AreaService {
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
     * 增加地区气泡数（新增帖子后）
     *
     * @param Area
     * @return boolean
     */
    boolean addBubbleNum(Area area);

    /*
     * 减少地区气泡数（删除帖子后）
     *
     * @param Area
     * @return boolean
     */
    boolean reduceBubbleNum(Area area);
}
