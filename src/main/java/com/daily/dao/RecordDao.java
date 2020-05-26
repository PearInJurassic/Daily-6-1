package com.daily.dao;

import com.daily.entity.Record;

import java.util.Date;
import java.util.List;

public interface RecordDao {
    /*
     * 根据用户ID得到动态列表
     *
     * @param userId
     * @return List<Record>
     */
    List<Record> getRecordListByUserId(int userId);
    /*
     * 根据用户ID和时间轴类别得到动态列表
     *
     * @param userId,timeAxisType
     * @return List<Record>
     */
    List<Record> getRecordListByUserIdAndType(int userId, String timeAxisType);
    /*
     * 根据用户ID和时间范围得到动态列表
     *
     * @param userId,Date1,Date2
     * @return List<Record>
     */
    List<Record> getRecordListByUserIdAndTime(int userId, Date beginTime, Date endTime);
    /*
     * 根据用户ID和时间轴类别和时间范围得到动态列表
     *
     * @param userId,timeAxisType,Date1,Date2
     * @return List<Record>
     */
    List<Record> getRecordListByUserIdAndTypeAndTime(int userId, String timeAxisType, Date beginTime, Date endTime);
    /*
     * 根据用户ID和内容关键字得到动态列表
     *
     * @param string
     * @return List<Record>
     */
    List<Record> getRecordListByUserIdAndKeyWord(int userId, String keyWord);
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
