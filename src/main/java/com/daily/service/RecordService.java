package com.daily.service;

import com.daily.entity.Record;
import com.daily.entity.RecordExpand;

import java.util.Date;
import java.util.List;

public interface RecordService {
    /*
     * 根据用户ID得到动态列表
     *
     * @param userId
     * @return List<RecordExpand>
     */
    List<RecordExpand> getRecordListByUserId(int userId);
    /*
     * 根据用户ID和内容关键字得到动态列表
     *
     * @param string
     * @return List<RecordExpand>
     */
    List<RecordExpand> getRecordListByUserIdAndKeyWord(int userId, String keyWord);
    /*
     * 根据用户ID和时间轴类别得到动态列表
     *
     * @param userId,timeAxisType
     * @return List<RecordExpand>
     */
    List<RecordExpand> getRecordListByUserIdAndType(int userId, String timeAxisType);
    /*
     * 根据用户ID和时间范围得到动态列表
     *
     * @param userId,Date1,Date2
     * @return List<RecordExpand>
     */
    List<RecordExpand> getRecordListByUserIdAndTime(int userId, Date beginTime, Date endTime);
    /*
     * 根据用户ID和时间轴类别和时间范围得到动态列表
     *
     * @param userId,timeAxisType,Date1,Date2
     * @return List<RecordExpand>
     */
    List<RecordExpand> getRecordListByUserIdAndTypeAndTime(int userId, String timeAxisType, Date beginTime, Date endTime);
    /*
     * 新增动态
     *
     * @param Record
     * @return boolean
     */
    boolean insertRecord(Record record);
    /*
     * 修改动态
     *
     * @param Record
     * @return boolean
     */
    boolean updateRecord(Record record);
    /*
     * 删除动态
     *
     * @param recordId
     * @return boolean
     */
    boolean deleteRecord(int recordId);
}
