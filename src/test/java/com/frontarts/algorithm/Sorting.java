package com.frontarts.algorithm;

import org.testng.annotations.Test;

import javax.xml.ws.http.HTTPException;

/**
 * Created by IntelliJ IDEA. @3/13/14 11:15 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Sorting {

    private int[] a = {8, 7, 9, 5, 4, 3, 2, 1, 0};

    public void bubbleSort() {

        for (int out = a.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) swap(in, in + 1);
            }
        }
    }

    // doesn't work since
    public void bubbleSortReverse() {

        for (int out = 0; out < a.length - 1; out++) {
            for (int in = a.length - 1; in > out; in--) {
                if (a[in] < a[in - 1]) swap(in, in - 1);
            }
        }
    }


    private void swap(int ia, int ib) {

        int var = a[ia];
        a[ia] = a[ib];
        a[ib] = var;
    }

    public void selectionSort() {
        for (int out = 0; out < a.length - 1; out++) {
            int min = out;
            for (int in = out + 1; in < a.length; in++) {
                if (a[in] < a[min])
                    min = in;
            }
            swap(min, out);
        }
    }

    public void selectionSortReverse() {

        for (int out = a.length - 1; out > 0; out--) {
            int max = out;
            for (int in = 0; in < out; in++) {
                if (a[in] > a[max])
                    max = in;
            }
            swap(out, max);
        }
    }

    public void insertionSort() {
        for (int out = 1; out < a.length; out++) {
            for (int j = out; j > 0 && a[j] < a[j - 1]; j--) {
                swap(j - 1, j);
            }
        }
    }

    @Test
    public void sortTest() {

        Sorting test = new Sorting();
        test.bubbleSortReverse();
        for (int i : test.a) {
            System.out.print(i + ",");
        }
    }

    public int shit() throws HTTPException {
        int i = 10;
        try {
            return -1;
        } catch (HTTPException e) {
            throw new HTTPException(0);
        }
    }
}
