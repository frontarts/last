package com.frontarts.algorithm;

/**
 * Created by IntelliJ IDEA. @3/11/14 9:54 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class BinarySearch {

    public int search(int[] ss, int key) {
        int low = 0;
        int up = ss.length - 1;
        while (true) {
            int cur = (low + up) / 2;

            if (ss[cur] == key) return cur;
            else if (low > up) return -1;
            else {
                if (ss[cur] < key) low = cur + 1;
                else if (ss[cur] > key) up = cur - 1;
            }
        }

    }

    public int searchR(int[] ii, int key) {

        int low = 0;
        int up = ii.length - 1;
        return search(ii, key, low, up);
    }

    private int search(int[] ii, int key, int low, int up) {

        int cur = (low + up) / 2;
        if (low > up) return -1;
        else if (ii[cur] == key) return cur;
        else {
            if (ii[cur] < key) low = cur + 1;
            else if (ii[cur] > key) up = cur - 1;
        }
        return search(ii, key, low, up);
    }

    // max

    public int max(int[] numbers) {

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += numbers[k];
                    if (sum > max) max = sum;
                }


            }
        }
        return max;
    }
}

//    public int maxSubsequenceSum2(int a[]) {
//        int maxSum = 0;
//        for (int i = 0; i < a.length; i++) {
//            int thisSum = 0;
//            for (int j = i; j < a.length; j++) {
//                thisSum += a[j];
//                if (thisSum > maxSum) {
//                    maxSum = thisSum;
//                    seqStart = i;
//                    seqEnd = j;
//                }
//            }
//        }
//        System.out.println(seqStart);
//        System.out.println(seqEnd);
//        return maxSum;
//    }
//
//    public int maxSubsequenceSum1(int a[]) {
//        int maxSum = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i; j < a.length; j++) {
//                int thisSum = 0;
//                for (int k = i; k <= j; k++) {
//                    thisSum += a[k];
//                    if (thisSum > maxSum) {
//                        maxSum = thisSum;
//                        seqStart = i;//最大公共子序列索引的起始坐标
//                        seqEnd = j;//最大公共子序列索引的末尾坐标
//                    }
//                }
//            }
//        }
//        System.out.println(seqStart);
//        System.out.println(seqEnd);
//        return maxSum;
//    }
