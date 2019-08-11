package com.mitix.len.jdk8base.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author oldflame-jm
 * @create 2017/12/30
 * ${DESCRIPTION}
 */
public class BootStrapClassloaderExp {
    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        //获取Bootstrap类装载器的参数
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
