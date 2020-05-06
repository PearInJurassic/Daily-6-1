package com.daily.web;

import com.daily.service.QiNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QiNiuController {

    @Autowired
    private QiNiuService qiNiuService;

    @PostMapping("/upload")
    private Map<String, Object> upload(@RequestParam("file") MultipartFile uploadFile) throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
            String result = qiNiuService.uploadFile(uploadFile);
            if(result!=null){
                modelMap.put("code","1");
                modelMap.put("fileName",result);
            }
            else {
                modelMap.put("code","2");
                modelMap.put("message","上传失败");
            }
            return modelMap;
    }
}