package com.massizhi.daily.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TimeAxisDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private TimeAxisDao timeAxisDao;

    @Test
    void getTimeAxisTypeById() {
        assertEquals("心情", timeAxisDao.getTimeAxisTypeById(3));
    }
}