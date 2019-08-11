package com.mitix.len.inttver;

import org.junit.Test;
import sun.net.util.IPAddressUtil;

/**
 * @author oldflame-jm
 * @create 2018/9/3
 * ${DESCRIPTION}
 */
public class UtilExp {
    @Test
    public void testGetLocalIPAddress() {
        System.out.println(IPAddressUtil.textToNumericFormatV6("local"));
    }
}
