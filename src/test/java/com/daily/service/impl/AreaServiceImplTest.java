package com.daily.service.impl;

import com.daily.entity.Area;
import com.daily.service.AreaService;
import com.daily.service.PostService;
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

    @Autowired
    private PostService postService;

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
        assertEquals(true,areaService.addBubbleNum(101001));
    }

    @Test
    public void reduceBubbleNum() {
        Integer postId = 15;
        System.out.println(postService.getPostByPostId(postId).getAreaId());
        assertEquals(true,areaService.reduceBubbleNum(postService.getPostByPostId(postId).getAreaId()));
    }

    @Test
    @Ignore
    public void refreshBubbleNum() {
        assertEquals(true,areaService.refreshBubbleNum());
    }

    @Test
    @Ignore
    public void getAreaNameById() {
        assertEquals("中国",areaService.getAreaNameById(0));
    }
}