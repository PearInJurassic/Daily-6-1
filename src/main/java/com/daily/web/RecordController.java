package com.daily.web;

import com.daily.entity.Record;
import com.daily.entity.RecordExpand;
import com.daily.service.RecordService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
public class RecordController {
    @Autowired
    private RecordService recordService;

    /*
     * 根据用户ID和时间轴类别得到动态列表
     *
     * @param userId,timeAxisType
     * @return Map<recordList, List<RecordExpand>>
     */
    @RequestMapping(value = "/ListByUIdAndType", method = RequestMethod.GET)
    private Map<String, Object> ListByUIdAndType(Integer uId, String type) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecordExpand> recordList=recordService.getRecordListByUserIdAndType(uId,type);
        modelMap.put("recordList", recordList);
        return modelMap;
    }

    /*
     * 根据用户ID和时间范围得到动态列表
     *
     * @param userId,Date1,Date2
     * @return Map<recordList, List<RecordExpand>>
     */
    @RequestMapping(value = "/ListByUIdAndTime", method = RequestMethod.GET)
    private Map<String, Object> ListByUIdAndTime(Integer uId, Date begin, Date end) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecordExpand> recordList=recordService.getRecordListByUserIdAndTime(uId,begin,end);
        modelMap.put("recordList", recordList);
        return modelMap;
    }

    /*
     * 根据用户ID和时间轴类别和时间范围得到动态列表
     *
     * @param userId,timeAxisType,Date1,Date2
     * @return Map<recordList, List<RecordExpand>>
     */
    @RequestMapping(value = "/ListByUIdAndTT", method = RequestMethod.GET)
    private Map<String, Object> ListByUIdAndTT
            (Integer uId,String type,Date b,Date e) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecordExpand> recordList=recordService.
                getRecordListByUserIdAndTypeAndTime(uId,type,b,e);
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
    private Map<String, Object> deleteRecord(Integer recordId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",recordService.deleteRecord(recordId));
        return modelMap;
    }
}
