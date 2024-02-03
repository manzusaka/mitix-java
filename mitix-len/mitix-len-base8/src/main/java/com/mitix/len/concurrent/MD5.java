package com.mitix.len.concurrent;

import com.mitix.len.concurrent.log.MD5Util;
import com.mitix.len.concurrent.log.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class MD5 {
    public static void main(String[] args) {
        Map<String, Integer> md5Map = new HashMap<>();


        for (int i = 0; i < 10000000; i++) {
            String md5ret = MD5Util.getStrMD5(String.valueOf(i));
            md5ret = md5ret.substring(8, 20);
            if (md5Map.get(md5ret) == null) {
                md5Map.put(md5ret, i);
            } else {
                System.out.printf("index %s,currentindex %s, md5ret is repetition = %s\n", md5Map.get(md5ret), i, md5ret);
            }
        }

    }
}
