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
    void getRecordListByUserIdAndTime() {
        List<Record> recordList = recordDao.getRecordListByUserIdAndTime(1,new Date(120,3,30),new Date(120,3,31));
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByUserIdAndTypeAndTime() {
        List<Record> recordList = recordDao.getRecordListByUserIdAndTypeAndTime(1,"学习",new Date(120,3,30),new Date(120,3,31));
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByUserId() {
        List<Record> recordList = recordDao.getRecordListByUserId(1);
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByUserIdAndType() {
        List<Record> recordList = recordDao.getRecordListByUserIdAndType(1,"学习");
        // 验证预期值和实际值是否相符
        assertEquals(2, recordList.size());
    }

    @Test
    void getRecordListByUserIdAndKeyWord() {
        List<Record> recordList = recordDao.getRecordListByUserIdAndKeyWord(1,"嗯");
        // 验证预期值和实际值是否相符
        assertEquals(1, recordList.size());
    }

}