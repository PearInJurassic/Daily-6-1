package com.daily.controller;

import com.daily.entity.Area;
import com.daily.service.AreaService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 获取地区信息
     *
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> listArea(int areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = new Area();
        // 获取区域列表
        area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }
}
