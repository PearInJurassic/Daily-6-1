package com.daily.dao;

import com.daily.entity.Record;

import java.util.List;

public interface RecordDao {
    /*
     * 通过地区ID得到地区信息
     *
     * @param timeAixsId
     * @return List<Record>
     */
    List<Record> getRecordListById(int timeAixsId);

    /*
     * 通过地区ID得到地区信息
     *
     * @param recordId
     * @return Record
     */
    Record getRecordByRecordId(int recordId);


}
