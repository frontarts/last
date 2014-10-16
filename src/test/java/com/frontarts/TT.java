package com.frontarts;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA. @3/20/14 4:55 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TT {

    @Test
    public String testStartProcess() {
        Process process = null;
        String line;
        try {
            process = Runtime.getRuntime().exec("cmd /c dir windows");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testAssert() {
        int i = 10;
        assert i < 0;
        String shit = "";
        shit.split("\\s");
        char[] shits = shit.toCharArray();

        System.out.println("running to the end");
    }

    public String reverseWords(String s) {
        if (s.isEmpty() || s.trim().isEmpty()) return "";
        if (null == s) throw new IllegalArgumentException("Input is null or empty!");

        String[] words = s.split("\\s");
        String output = words[words.length - 1];
        if (words.length > 1) {
            for (int i = words.length - 1; i > 0; i--) {
                output += "\\s" + reversAWord(words[i - 1]);
            }
        }

        return output;
    }

    private String reversAWord(String word) {
        char[] chars = word.trim().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("shit"));
            }
}
