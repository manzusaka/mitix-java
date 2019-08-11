package com.mitix.len.jdk7.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by oldflame on 2017/5/14.
 */
public class ReaderSiExp {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter characters , q to quit");
        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
