package com.mitix.len.multithread4oood.balking;

/**
 * @author oldflame-jm
 * @create 2018/4/8
 * ${DESCRIPTION}
 */
public class DataMainTest {
    public static void main(String[] args) {
        MitixData data = new MitixData("test.txt", "");
        new ChangedThread("change", data).start();
        new ServerThread("server", data).start();
    }
}
