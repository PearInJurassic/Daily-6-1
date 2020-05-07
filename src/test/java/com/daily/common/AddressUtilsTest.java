package com.daily.common;

import org.junit.Ignore;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class AddressUtilsTest {

    private static AddressUtils addressUtils = new AddressUtils();;

    @Test
    public void getAddresses() throws UnsupportedEncodingException {
        assertEquals("天津市",addressUtils.getAddresses("ip=183.154.231.31&json=true","GBK"));
    }
}