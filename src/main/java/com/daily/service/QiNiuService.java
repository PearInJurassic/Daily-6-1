package com.daily.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import java.io.File;
import java.io.InputStream;
/**
 * @author 言曌
 * @date 2018/4/5 下午9:38
 */
public interface QiNiuService {
    /**
     * 上传文件
     * <p>
     * (文件上传)
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    String uploadFile(File file) throws QiniuException;
    /**
     * 上传文件
     * <p>
     * (文件流上传)
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    //Response uploadFile(InputStream inputStream) throws QiniuException;
    /**
     * 删除
     *
     * @param key
     * @return
     * @throws QiniuException
     */
    boolean delete(String key) throws QiniuException;
}