package com.massizhi.daily.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.massizhi.daily.entity.Record;
import com.massizhi.daily.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userRecord")
public class RecordController {
    @Autowired
    private RecordService recordService;

    /*
     * 根据用户ID和时间轴类别得到动态列表
     *
     * @param userId,timeAxisType
     * @return Map<recordList, List<Record>>
     */
    @RequestMapping(value = "/getRecordListByUserIdAndType", method = RequestMethod.POST)
    private Map<String, Object> getRecordListByUserIdAndType(int userId, String timeAxisType) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList=recordService.getRecordListByUserIdAndType(userId,timeAxisType);
        modelMap.put("recordList", recordList);
        return modelMap;
    }

    /*
     * 根据用户ID和时间范围得到动态列表
     *
     * @param userId,Date1,Date2
     * @return Map<recordList, List<Record>>
     */
    @RequestMapping(value = "/getRecordListByUserIdAndTime", method = RequestMethod.POST)
    private Map<String, Object> getRecordListByUserIdAndTime(int userId, Date beginTime, Date endTime) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList=recordService.getRecordListByUserIdAndTime(userId,beginTime,endTime);
        modelMap.put("recordList", recordList);
        return modelMap;
    }

    /*
     * 根据用户ID和时间轴类别和时间范围得到动态列表
     *
     * @param userId,timeAxisType,Date1,Date2
     * @return Map<recordList, List<Record>>
     */
    @RequestMapping(value = "/getRecordListByUserIdAndTypeAndTime", method = RequestMethod.POST)
    private Map<String, Object> getRecordListByUserIdAndTypeAndTime
            (int userId,String timeAxisType,Date beginTime,Date endTime) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Record> recordList=recordService.
                getRecordListByUserIdAndTypeAndTime(userId,timeAxisType,beginTime,endTime);
        modelMap.put("recordList", recordList);
        return modelMap;
    }

    /*
     * 新增动态
     *
     * @param Record
     * @return Map<success, boolean>
     */
    @RequestMapping(value = "/insertRecord", method = RequestMethod.POST)
    private Map<String, Object> insertRecord(@RequestBody Record record)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",recordService.insertRecord(record));
        return modelMap;
    }

    /*
     * 修改动态
     *
     * @param Record
     * @return Map<success, boolean>
     */
    @RequestMapping(value = "/updateRecord", method = RequestMethod.POST)
    private Map<String, Object> updateRecord(@RequestBody Record record)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",recordService.updateRecord(record));
        return modelMap;
    }

    /*
     * 删除动态
     *
     * @param recordId
     * @return Map<success, boolean>
     */
    @RequestMapping(value = "/deleteRecord", method = RequestMethod.GET)
    private Map<String, Object> deleteRecord(int recordId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",recordService.deleteRecord(recordId));
        return modelMap;
    }
}
