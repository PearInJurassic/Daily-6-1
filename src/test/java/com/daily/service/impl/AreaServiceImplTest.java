package com.daily.service.impl;

import com.daily.entity.Area;
import com.daily.service.AreaService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {
    @Autowired
    private AreaService areaService;

    @Test
    @Ignore
    public void getAreaById() {
        Area area = areaService.getAreaById(35);
        assertEquals("福州市", area.getAreaName());
    }

    @Test
    @Ignore
    public void getAreaByName() {
        Area area = areaService.getAreaByName("福州市");
        assertEquals(35, area.getAreaId());
    }

    @Test
    @Ignore
    public void getAreaListByBelongAreaId() {
        List<Area> areaList = areaService.getAreaListByBelongAreaId(0);
        assertEquals(34,areaList.size());
    }

    @Test
    @Ignore
    public void addBubbleNum() {
        Area area = areaService.getAreaById(35);
        assertEquals(true,areaService.addBubbleNum(area));
    }

    @Test
    public void deleteBubbleNum() {
        Area area = areaService.getAreaById(35);
        assertEquals(true,areaService.deleteBubbleNum(area));
    }
}