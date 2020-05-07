package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.AreaDao;
import com.massizhi.daily.dao.RecordDao;
import com.massizhi.daily.entity.Record;
import com.massizhi.daily.entity.RecordExpand;
import com.massizhi.daily.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<RecordExpand> getRecordListByUserId(int userId) {
        List<Record> recordList=recordDao.getRecordListByUserId(userId);
        List<RecordExpand> recordExpandList=new ArrayList<RecordExpand>();
        IntStream.range(0, recordList.size()).forEach(i -> {
            RecordExpand recordExpand = new RecordExpand();
            Record record = recordList.get(i);
            recordExpand.setRecord(record);
            if(record.getAreaId() != null && record.getAreaId() != 0)
                recordExpand.setAreaName(areaDao.getAreaNameById(record.getAreaId()));
            recordExpandList.add(recordExpand);
        });
        return recordExpandList;
    }

    @Override
    public List<RecordExpand> getRecordListByUserIdAndKeyWord(int userId, String keyWord) {
        List<Record> recordList=recordDao.getRecordListByUserIdAndKeyWord(userId,keyWord);
        List<RecordExpand> recordExpandList=new ArrayList<RecordExpand>();
        IntStream.range(0, recordList.size()).forEach(i -> {
            RecordExpand recordExpand = new RecordExpand();
            Record record = recordList.get(i);
            recordExpand.setRecord(record);
            if(record.getAreaId() != null && record.getAreaId() != 0)
                recordExpand.setAreaName(areaDao.getAreaNameById(record.getAreaId()));
            recordExpandList.add(recordExpand);
        });
        return recordExpandList;
    }

    @Override
    public List<RecordExpand> getRecordListByUserIdAndType(int userId, String timeAxisType) {
        List<Record> recordList=recordDao.getRecordListByUserIdAndType(userId,timeAxisType);
        List<RecordExpand> recordExpandList=new ArrayList<RecordExpand>();
        IntStream.range(0, recordList.size()).forEach(i -> {
            RecordExpand recordExpand = new RecordExpand();
            Record record = recordList.get(i);
            recordExpand.setRecord(record);
            if(record.getAreaId() != null && record.getAreaId() != 0)
                recordExpand.setAreaName(areaDao.getAreaNameById(record.getAreaId()));
            recordExpandList.add(recordExpand);
        });
        return recordExpandList;
    }

    @Override
    public List<RecordExpand> getRecordListByUserIdAndTime(int userId, Date beginTime, Date endTime) {
        List<Record> recordList=recordDao.getRecordListByUserIdAndTime(userId,beginTime,endTime);
        List<RecordExpand> recordExpandList=new ArrayList<RecordExpand>();
        IntStream.range(0, recordList.size()).forEach(i -> {
            RecordExpand recordExpand = new RecordExpand();
            Record record = recordList.get(i);
            recordExpand.setRecord(record);
            if(record.getAreaId() != null && record.getAreaId() != 0)
                recordExpand.setAreaName(areaDao.getAreaNameById(record.getAreaId()));
            recordExpandList.add(recordExpand);
        });
        return recordExpandList;
    }

    @Override
    public List<RecordExpand> getRecordListByUserIdAndTypeAndTime(int userId, String timeAxisType, Date beginTime, Date endTime) {
        List<Record> recordList=recordDao.getRecordListByUserIdAndTypeAndTime(userId,timeAxisType,beginTime,endTime);
        List<RecordExpand> recordExpandList=new ArrayList<RecordExpand>();
        IntStream.range(0, recordList.size()).forEach(i -> {
            RecordExpand recordExpand = new RecordExpand();
            Record record = recordList.get(i);
            recordExpand.setRecord(record);
            if(record.getAreaId() != null && record.getAreaId() != 0)
                recordExpand.setAreaName(areaDao.getAreaNameById(record.getAreaId()));
            recordExpandList.add(recordExpand);
        });
        return recordExpandList;
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
