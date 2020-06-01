package com.daily.web;

import com.daily.common.ImageRecgUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImageRegcController {
    /*
     * 通过二进制数组获取地区信息
     *
     * @param byte[]
     * @return Map<"keyWordList", List<String>>
     */
    @RequestMapping(value = "/imageRegcByByteArray", method = RequestMethod.POST)
    private Map<String, Object> imageRegcByByteArray(byte[] image) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<String> keyWordList= ImageRecgUtil.imageRecgByByteArray(image);
        modelMap.put("keyWordList", keyWordList);
        return modelMap;
    }
    /*
     * 通过二进制数组获取地区信息
     *
     * @param String
     * @return Map<"keyWordList", List<String>>
     */
    @RequestMapping(value = "/imageRecgByBase64", method = RequestMethod.POST)
    private Map<String, Object> imageRecgByBase64(String base) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<String> keyWordList= ImageRecgUtil.imageRecgByBase64(base);
        modelMap.put("keyWordList", keyWordList);
        return modelMap;
    }
}
