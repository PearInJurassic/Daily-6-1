package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.RecordDao;
import com.massizhi.daily.entity.Record;
import com.massizhi.daily.entity.UserFollow;
import com.massizhi.daily.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<Record> getRecordListByUserIdAndType(int userId, String timeAxisType) {
        return recordDao.getRecordListByUserIdAndType(userId,timeAxisType);
    }

    @Override
    public List<Record> getRecordListByUserIdAndTime(int userId, Date beginTime, Date endTime) {
        return recordDao.getRecordListByUserIdAndTime(userId,beginTime,endTime);
    }

    @Override
    public List<Record> getRecordListByUserIdAndTypeAndTime(int userId, String timeAxisType, Date beginTime, Date endTime) {
        return recordDao.getRecordListByUserIdAndTypeAndTime(userId,timeAxisType,beginTime,endTime);
    }

    @Override
    public boolean insertRecord(Record record) {
        if (record.getRecordId() != null) {
            try {
                int effectedNum = recordDao.insertRecord(record);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("增加动态失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("增加动态失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("增加动态失败");
        }
    }

    @Override
    public boolean updateRecord(Record record) {
        if (record.getRecordId() != null) {
            try {
                int effectedNum = recordDao.updateRecord(record);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改动态失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改动态失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("修改动态失败");
        }
    }

    @Override
    public boolean deleteRecord(int recordId) {
        if (recordId != 0) {
            try {
                int effectedNum = recordDao.deleteRecord(recordId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除动态失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除动态失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("删除动态失败");
        }
    }
}
