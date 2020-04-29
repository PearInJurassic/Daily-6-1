package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Record;

import java.util.List;

public interface RecordDao {
    /*
     * 根据用户ID得到动态列表
     *
     * @param userId
     * @return List<Record>
     */
    List<Record> getRecordListByAreaId(int userId);

}
