package com.frontarts.algorithm;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

/**
 * Created by IntelliJ IDEA. @5/8/14 11:26 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ArrayPartition {

    private int[] a;
    private int current;

    public ArrayPartition(int maxSize) {

        a = new int[maxSize];
        current = 0;

    }

    public int partitionIt(int left, int right, int pivot) {
        int leftPivot = left - 1;
        int rightPivot = right + 1;

        for (; ; ) {
            while (leftPivot < right && a[++leftPivot] < pivot) ;
            while (rightPivot > left && a[--rightPivot] > pivot) ;
            if (leftPivot > rightPivot) break;
            else swap(leftPivot, rightPivot);
        }
        return leftPivot;
    }

    public void swap(int dexA, int dexB) {

        int tmp = a[dexA];
        a[dexA] = a[dexB];
        a[dexB] = tmp;

    }

    private void insert(int n) {
        a[current++] = n;
    }


    private int size() {
        return current;
    }

    private void display() {
        System.out.print("A=");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {

        int maxSize = 16;
        ArrayPartition array = new ArrayPartition(maxSize);

        for (int i = 0; i < maxSize; i++) {
            int n = (int) (Math.random() * 199);
            array.insert(n);
        }
        array.display();

        int pivot = 150;
        System.out.print("Pivot is " + pivot);

        int partDex = array.partitionIt(0, array.size() - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        array.display();
    }

}

