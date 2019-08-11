/*
 * Copyright (c) 2010
 * @date 2016
 * @author oldflame-Jm
 *
 * Apache License Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.mitix.len.jdk8base.regularexpression.exp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author oldflame-Jm
 * TODO
 * @version 1.0.0
 */
public class Example1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //简单的正则表达式
        parttenHandler("abc".matches("..."));
        parttenHandler("a8279b".replaceAll("\\d", "-"));
        //匹配3个字符   没个字符都哦是字母
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("kax");
        parttenHandler(m.matches());
    }

    private static void parttenHandler(Object object) {
        System.out.println(object);
    }

}
