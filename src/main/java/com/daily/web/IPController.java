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

    @RequestMapping(value = "/getaddress", method = RequestMethod.GET)
    private Map<String, Object> getAddress(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userIp = ipUtil.getIpAddr(request);
        String syIp = "183.154.231.31";
        //address = "ip=" + ip + "&json=true";
        String city = addressUtils.getAddresses(userIp, "utf-8");
        String syCity = addressUtils.getAddresses(syIp, "utf-8");
        //address = addressUtils.getAddresses(address,"utf-8");
        modelMap.put("ip", userIp);
        modelMap.put("city", city);
        modelMap.put("syCity",syCity);
        return modelMap;
    }
}
