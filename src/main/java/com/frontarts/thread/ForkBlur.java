package com.frontarts.thread;

import java.util.concurrent.RecursiveAction;

/**
 * Created by IntelliJ IDEA. @7/24/2014 4:49 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ForkBlur extends RecursiveAction {

    private int[] source;
    private int start;
    private int length;
    private int[] destination;

    private int blurWidth = 15;

    public ForkBlur(int[] source, int start, int length, int[] destination) {
        this.source = source;
        this.start = start;
        this.length = length;
        this.destination = destination;
    }

    protected void computeDirectly() {
        int sidePixels = (blurWidth - 1) / 2;
        for (int index = start; index < start + length; index++) {
            float rt = 0, gt = 0, bt = 0;
            for (int mi = -sidePixels; mi <= sidePixels; mi++) {
                int mIndex = Math.min(Math.max(mi + index, 0), source.length - 1);
                int pixel = source[mIndex];
                rt += (float) ((pixel & 0x00FF0000) >> 16) / blurWidth;
                gt += (float) ((pixel & 0x00FF0000) >> 8) / blurWidth;
                bt += (float) ((pixel & 0x00FF0000) >> 0) / blurWidth;
            }

            int dpixel = (0xff000000) | ((int) rt) << 16 | ((int) gt << 8) | ((int) bt << 0);
            destination[index] = dpixel;
        }
    }

    @Override
    protected void compute() {
//        if (mLength < sThreshold) {
//                   computeDirectly();
//                   return;
//               }
//
//               int split = mLength / 2;
//
//               invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
//                       new ForkBlur(mSource, mStart + split, mLength - split,
//                       mDestination));
//
    }
}
