package com.daily.dao;

import com.daily.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void getAreaById() {
        Area area = areaDao.getAreaById(1);
        assertEquals("福州",area.getAreaName());
    }

    @Test
    @Ignore
    public void getAreaByName() {
        Area area = areaDao.getAreaByName("福州");
        assertEquals(1,area.getAreaId());
    }

    @Test
    @Ignore
    public void getAreaListByBelongAreaId() {
        List<Area> areaList = areaDao.getAreaListByBelongAreaId(0);
        assertEquals(33,areaList.size());
    }

    @Test
    public void updateBubbleNum() {
        Area area = areaDao.getAreaById(1);
        area.setBubbleNum(0);
        assertEquals(true,areaDao.updateBubbleNum(area));
    }
}