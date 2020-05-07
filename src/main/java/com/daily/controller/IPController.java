package com.daily.controller;

import com.daily.common.AddressUtils;
import com.daily.common.IpUtil;
import com.daily.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/ip")
public class IPController {
    @Autowired
    private IpUtil ipUtil;
    @Autowired
    private AddressUtils addressUtils;

    @RequestMapping(value = "/getaddress", method = RequestMethod.GET)
    private String getAddress() throws UnsupportedEncodingException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String address = new String();
        address = ipUtil.getIpAddr(request);
        address = addressUtils.getAddresses(address,"gbk");
        return address;
    }
}
