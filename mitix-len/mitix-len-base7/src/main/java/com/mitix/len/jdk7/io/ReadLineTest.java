package com.mitix.len.jdk7.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by oldflame on 2017/5/14.
 */
public class ReadLineTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("enter line of text");
        System.out.println("enter stop then quit");
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));
    }
}
