package com.daily.service;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.QiNiuProperties;

@SpringBootTest
@RunWith(SpringRunner.class)

public class QiNiuServiceTest {
    @Autowired
    private QiNiuService qiNiuService;
    @Test
    public void uploadFile() throws QiniuException {
        String fileName = "C:\\Users\\Yan\\Pictures\\y.png";
        File file = new File(fileName);
        String res = qiNiuService.uploadFile(file);//根据 http://域名/key 就能访问文件
        System.out.println(res);
        //assertEquals(null,res);
    }
}