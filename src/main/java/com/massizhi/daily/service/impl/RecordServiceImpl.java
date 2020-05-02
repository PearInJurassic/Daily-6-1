package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.RecordDao;
import com.massizhi.daily.entity.Record;
import com.massizhi.daily.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Record> getRecordListByUserId(int userId) {
        return recordDao.getRecordListByUserId(userId);
    }

    @Override
    public List<Record> getRecordListByUserIdAndKeyWord(int userId, String keyWord) {
        return recordDao.getRecordListByUserIdAndKeyWord(userId,keyWord);
    }
}
