package com.daily.service.impl;

import com.daily.dao.AreaDao;
import com.daily.entity.Area;
import com.daily.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.getAreaById(areaId);
    }

    @Override
    public Area getAreaByName(String areaName) {
        return areaDao.getAreaByName(areaName);
    }

    @Override
    public List<Area> getAreaListByBelongAreaId(int belongAreaId) {
        return areaDao.getAreaListByBelongAreaId(belongAreaId);
    }

    @Override
    public boolean addBubbleNum(Area area) {
        //如果所属地区ID小于0（即还有上层地区,目前最上层为中国（-1））
        while(area.getBelongAreaId() >= 0) {
            //气泡数加1
            area.setBubbleNum(area.getBubbleNum() + 1);
            try {
                boolean b = areaDao.updateBubbleNum(area);
                if(b == false) {
                    throw new RuntimeException("添加气泡数操作失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加气泡数操作失败：" + e.getMessage());
            }
            area = areaDao.getAreaById(area.getBelongAreaId());
        }
        return true;
    }

    @Override
    public boolean reduceBubbleNum(Area area) {
        //如果所属地区ID小于0（即还有上层地区,目前最上层为中国（-1））
        while(area.getBelongAreaId() >= 0) {
            //气泡数加1
            area.setBubbleNum(area.getBubbleNum() - 1);
            try {
                boolean b = areaDao.updateBubbleNum(area);
                if(b == false) {
                    throw new RuntimeException("减少气泡数操作失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("减少气泡数操作失败：" + e.getMessage());
            }
            area = areaDao.getAreaById(area.getBelongAreaId());
        }
        return true;
    }

    @Override
    public boolean refreshBubbleNum() {
        List<Area> areaList = areaDao.getAreaList();
        for(Area area : areaList) {
            area.setBubbleNum(0);
            try {
                boolean b = areaDao.updateBubbleNum(area);
                if(b == false) {
                    throw new RuntimeException("刷新气泡数操作失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("刷新气泡数操作失败：" + e.getMessage());
            }
        }
        return true;
    }

    @Override
    public String getAreaNameById(int areaId) {
        return areaDao.getAreaNameById(areaId);
    }
}
