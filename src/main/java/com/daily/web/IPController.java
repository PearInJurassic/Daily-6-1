package com.daily.web;

import com.daily.common.AddressUtils;
import com.daily.common.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ip")
public class IPController {
    @Autowired
    private IpUtil ipUtil;
    @Autowired
    private AddressUtils addressUtils;

    /*
     * 获取用户地址（城市）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getaddress", method = RequestMethod.GET)
    private Map<String, Object> getAddress(HttpServletRequest  request) throws UnsupportedEncodingException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String address = new String();
        address = ipUtil.getIpAddr(request);
        address = "http://whois.pconline.com.cn/ipJson.jsp?ip=" + address + "&json=true";
        modelMap.put("URL",address);
        return modelMap;
    }
}
