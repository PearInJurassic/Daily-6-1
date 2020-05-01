package com.daily.common;

import org.junit.Ignore;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class AddressUtilsTest {

    private static AddressUtils addressUtils = new AddressUtils();;

    @Test
    public void getAddresses() throws UnsupportedEncodingException {
        assertEquals("中国",addressUtils.getAddresses("ip=113.101.22.135","UTF-8"));
    }

    @Test
    @Ignore
    public void decodeUnicode() {
    }
}