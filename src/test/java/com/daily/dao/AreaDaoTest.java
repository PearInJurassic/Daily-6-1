package com.daily.dao;

import com.daily.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void getAreaById() {
        Area area = areaDao.getAreaById(1);
        assertEquals("福州",area.getAreaName());
    }

    @Test
    public void getAreaByName() {
        Area area = areaDao.getAreaByName("福州");
        assertEquals(1,area.getAreaId());
    }
}