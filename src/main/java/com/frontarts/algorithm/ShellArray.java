package com.frontarts.algorithm;

/**
 * Created by IntelliJ IDEA. @5/5/14 5:11 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ShellArray {

    private long[] a;
    private int count;

    public void shellSort() {
        int in, out;
        long temp;

        int h;
        for (h = 1; h <= count / 3; h = h * 3 + 1) ;

        while (h > 0) {
            for (out = h; out < count; out++) {
                temp = a[out];
                in = out;

                while (in > h - 1 && a[in - h] >= temp) {
                    a[in] = a[in - h];
                    in -= h;
                }

                a[in] = temp;
            }
            h = h - 1 / 3;
        }

    }
}
