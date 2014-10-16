package com.frontarts.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @5/7/14 11:18 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ArrayExercise {

    public void findDups(int[] n) {
        boolean[] flags = new boolean[1000];

        List<Integer> dups = new ArrayList<Integer>();
        for (int i : n) {
            if (flags[i]) dups.add(i);
            else flags[i] = true;
        }


    }
}
