package com.frontarts.tiger.collections;

import com.frontarts.tiger.inner.TalkingClock;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA. @3/6/14 4:59 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class CollectionTest {

    @Test
    public void testToArray(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("windows");
        strings.add("ios");
        strings.add("android");

        String[] T = new String[3];
        String[]  shit =  strings.toArray(T);
        System.out.println(shit.length);

        Object[] objectArray = new Object[4];
        objectArray[0] ="shit";
        objectArray[3] = 3;
        System.out.println(objectArray.length);
    }
}
