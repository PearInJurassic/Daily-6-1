package com.massizhi.daily.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class AreaDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private AreaDao areaDao;

    @Test
    void getAreaNameById() {
        //String areaName=areaDao.getAreaNameById(1);
        assertEquals("中国", areaDao.getAreaNameById(1));
    }
}