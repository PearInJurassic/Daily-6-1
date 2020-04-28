package com.daily.service.impl;

import com.daily.dao.AreaDao;
import com.daily.entity.Area;
import com.daily.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
