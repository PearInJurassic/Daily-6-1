package com.daily.common;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageRecgUtil {
    public static List<String> imageRecgByByteArray(byte[] image) {
        //设置APPID/AK/SK
        String APP_ID = "20142426";
        String API_KEY = "9NgtXbpEskhYhAEwGngRH7PX";
        String SECRET_KEY = "EL6qE5qZ8NWMnG5FQZ0uKyanLe9YuN2W";

        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "0");

//        //使用本地文件路径
//        String path = "E:\\huoguo.jpg";
//        //使用二进制数组
//        File file = new File(path);
//        BufferedImage bi;
//        byte[] image = new byte[0];
//        try {
//            bi = ImageIO.read(file);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bi, "jpg", baos);
//            image = baos.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 调用接口
        JSONObject res = client.advancedGeneral(image, options);
        JSONArray resultArray=res.getJSONArray("result");

        List<String> resultList=new ArrayList<String>();
        for(int i=0;i<3;i++) {
            JSONObject jsonObject=resultArray.getJSONObject(i);
            resultList.add(jsonObject.getString("keyword"));
        }
        return resultList;
        //System.out.println(res.toString(2));
        //System.out.println(res.toString());
        //System.out.println(first.getString("keyword"));
    }

    public static List<String> imageRecgByBase64(String base) {
        //设置APPID/AK/SK
        String APP_ID = "20142426";
        String API_KEY = "9NgtXbpEskhYhAEwGngRH7PX";
        String SECRET_KEY = "EL6qE5qZ8NWMnG5FQZ0uKyanLe9YuN2W";

        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "0");

        //将Base64转化为二进制数组
        byte[] image = Base64.decodeBase64(base.getBytes());

        // 调用接口
        JSONObject res = client.advancedGeneral(image, options);
        JSONArray resultArray=res.getJSONArray("result");

        List<String> resultList=new ArrayList<String>();
        for(int i=0;i<3;i++) {
            JSONObject jsonObject=resultArray.getJSONObject(i);
            resultList.add(jsonObject.getString("keyword"));
        }
        return resultList;
    }
}
