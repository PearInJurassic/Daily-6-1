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
    @Ignore
    public void updateBubbleNum() {
        Area area = areaDao.getAreaById(1);
        area.setBubbleNum(0);
        assertEquals(true,areaDao.updateBubbleNum(area));
    }

    @Test
    @Ignore
    public void addArea() {
        int n = 1, areaId, a = 3100000;
        Area area;
        String name;
        for(int j = 1; j <= n; j++) {
            areaId = a + j * 0;
            area = areaDao.getAreaById(areaId);
            name = area.getAreaName();
            int i, id = area.getAreaId();
            for (i = 1; i < 11; i++) {
                area.setAreaId(id + i);
                area.setAreaName(name + i);
                area.setBelongAreaId(id);
                area.setBubbleNum(0);
                areaDao.addArea(area);
            }
        }
    }

    @Test
    @Ignore
    public void getAreaList() {
        List<Area> areaList = areaDao.getAreaList();
        assertEquals(4100,areaList.size());
    }
}