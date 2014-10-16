package com.frontarts.leetcode;

/**
 * Created by IntelliJ IDEA. @6/24/14 11:38 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Solution {

    public String reverseWords(String s) {

        if (s.isEmpty() || s.trim().isEmpty()) return "";
        if (null == s) throw new IllegalArgumentException("Input is null or empty!");

        String[] words = s.split("\\s");
        String output = "";
        for (int i = words.length; i > 0; i--) {
            String var = words[i - 1];
            if (!var.isEmpty())
                output += " " + var;
        }

        return output.trim();
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
}
