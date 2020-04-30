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
    /*
     * 根据用户ID和时间轴ID得到动态列表
     *
     * @param userId,timeAxisId
     * @return List<Record>
     */
    List<Record> getRecordListByTwoId(int userId,int timeAxisId);
    /*
     * 新增动态
     *
     * @param Record
     * @return int
     */
    int insertRecord(Record record);
    /*
     * 修改动态
     *
     * @param Record
     * @return int
     */
    int updateRecord(Record record);
    /*
     * 删除动态
     *
     * @param recordId
     * @return int
     */
    int deleteRecord(int recordId);
}
