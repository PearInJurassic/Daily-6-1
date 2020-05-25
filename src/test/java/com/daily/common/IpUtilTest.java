package com.daily.common;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpUtilTest {
    @Autowired
    private IpUtil ipUtil;

    private HttpServletRequest httpServletRequest;

    @Test
    @Ignore
    public void getIpAddr() {
        httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ipStr = ipUtil.getIpAddr(httpServletRequest);
        assertEquals("12", ipStr);
    }
}