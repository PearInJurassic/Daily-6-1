package com.daily.web;

import com.daily.entity.Area;
import com.daily.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /*
     * 通过地区ID获取地区信息
     *
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(int areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = new Area();
        // 获取地区信息
        area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    /*
     * 通过地区名称获取地区信息
     *
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/getareabyname", method = RequestMethod.GET)
    private Map<String, Object> getAreaByName(String areaName) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = new Area();
        // 获取地区信息
        area = areaService.getAreaByName(areaName);
        modelMap.put("area", area);
        return modelMap;
    }

    /*
     * 通过所属地区ID获取地区信息列表
     *
     * @param belongAreaId
     * @return
     */
    @RequestMapping(value = "/getarealistbybelongareaid", method = RequestMethod.GET)
    private Map<String, Object> getAreaListByBelongAreaId(int belongAreaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> areaList = new ArrayList<Area>();
        // 获取区域列表
        areaList = areaService.getAreaListByBelongAreaId(belongAreaId);
        modelMap.put("areaList", areaList);
        return modelMap;
    }

    /*
     * 增加地区气泡数（新增帖子后）
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/addbubblenum", method = RequestMethod.GET)
    private Map<String, Object> addBubbleNum(int areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 增加地区气泡数（新增帖子后）
        modelMap.put("success", areaService.addBubbleNum(areaId));
        return modelMap;
    }

    /*
     * 减少地区气泡数（删除帖子后）
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/reducebubblenum", method = RequestMethod.GET)
    private Map<String, Object> reduceBubbleNum(int areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 减少地区气泡数（删除帖子后）
        modelMap.put("success", areaService.reduceBubbleNum(areaId));
        return modelMap;
    }
}
