package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Record;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class RecordDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private RecordDao recordDao;

    @Test
    void getRecordListByUserId() {
        List<Record> recordList = recordDao.getRecordListByUserId(1);
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByTwoId() {
        List<Record> recordList = recordDao.getRecordListByTwoId(1,1);
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByUserIdAndKeyWord() {
        List<Record> recordList = recordDao.getRecordListByUserIdAndKeyWord(1,"嗯");
        // 验证预期值和实际值是否相符
        assertEquals(1, recordList.size());
    }

    @Test
    void insertRecord() {
        //创建一个对象
        Record record = new Record();
        record.setRecordImg("12");
        record.setRecordContent("12");
        record.setAreaId(12);
        record.setRecordCreateTime(new Date());
        record.setTimeAxisId(12);
        record.setRecordUpdateTime(new Date());
        record.setUserId(12);
        //将该对象实例添加入库
        int effectedNum = recordDao.insertRecord(record);
        //检测影响行数
        assertEquals(1, effectedNum);
    }

    @Test
    void updateRecord() {
        //创建一个对象
        Record record = new Record();
        record.setRecordContent("test");
        record.setRecordId(1);
        //将该对象实例更新入库
        int effectedNum = recordDao.updateRecord(record);
        //检测影响行数
        assertEquals(1, effectedNum);
    }

    @Test
    void deleteRecord() {
        int effectedNum = recordDao.deleteRecord(3);
        //检测影响行数
        assertEquals(1, effectedNum);
    }

}