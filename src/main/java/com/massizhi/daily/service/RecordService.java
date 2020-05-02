package com.massizhi.daily.service;

import com.massizhi.daily.entity.Record;

import java.util.List;

public interface RecordService {
    /*
     * 根据用户ID得到动态列表
     *
     * @param userId
     * @return List<Record>
     */
    List<Record> getRecordListByUserId(int userId);
    /*
     * 根据用户ID和内容关键字得到动态列表
     *
     * @param string
     * @return List<Record>
     */
    List<Record> getRecordListByUserIdAndKeyWord(int userId,String keyWord);
}
