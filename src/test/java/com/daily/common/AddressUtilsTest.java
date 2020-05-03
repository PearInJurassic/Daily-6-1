package com.daily.common;

import org.junit.Ignore;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class AddressUtilsTest {

    private static AddressUtils addressUtils = new AddressUtils();;

    @Test
    @Ignore
    public void getAddresses() throws UnsupportedEncodingException {
        assertEquals("天津市",addressUtils.getAddresses("ip=118.28.67.126&json=true","GBK"));
    }
}