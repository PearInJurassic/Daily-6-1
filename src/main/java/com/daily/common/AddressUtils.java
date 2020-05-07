package com.daily.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @ClassName: AddressUtils
 * @Description: 根据ip获取用户的地址位置
 * @author: chd
 * @date: 2019年11月22日 下午2:14:13
 *
 */
@Configuration
public class AddressUtils {

    private static final Logger logger = LoggerFactory.getLogger(AddressUtils.class);

    /**
     * @param content        请求的参数 格式为：name=xxx&pwd=xxx
     * @param encodingString 服务器端请求编码。如GBK,UTF-8等
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getAddresses(String content, String encodingString) throws UnsupportedEncodingException {
        // 这里调用太平洋IP地址库API接口
        String urlStr = "http://whois.pconline.com.cn/ipJson.jsp";
        String returnStr = getResult(urlStr, content, encodingString);
        System.out.println("输出str\n");
        System.out.println(returnStr);
        System.out.println("输出str完成\n");
        if (returnStr != null) {
            String[] temp = returnStr.split(",");
            if (temp.length < 3) {
                return "0";// 无效IP，局域网测试
            }
            String[] string = temp[3].split(":");
            string[1] = string[1].replaceAll("\"", "");
            //System.out.println(string[1]);
            return string[1];
        }

        return null;
    }

    /**
     * @Title: getResult
     * @Description
     * @param: @param urlStr 请求的地址
     * @param: @param content  请求的参数 格式为：name=xxx&pwd=xxx
     * @param: @param encoding  服务器端请求编码。如GBK,UTF-8等
     * @param: @return
     */
    private static String getResult(String urlStr, String content, String encoding) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(33000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
            out.writeBytes(content);//
            out.flush();// 刷新
            out.close();// 关闭输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
            // ,以BufferedReader流来读取
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            logger.error("调用太平洋网通过ip获取地理位置服务发生异常", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}