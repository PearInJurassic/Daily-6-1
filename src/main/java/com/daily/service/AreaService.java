package com.daily.service;

import com.daily.entity.Area;

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
     * 增加地区气泡数
     *
     * @param Area
     * @return boolean
     */
    boolean addBubbleNum(Area area);
}
