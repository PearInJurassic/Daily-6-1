package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Area;

public interface AreaDao {
    /*
     * 通过地区ID得到地区名
     *
     * @param areaId
     * @return String
     */
    String getAreaNameById(int areaId);
}
