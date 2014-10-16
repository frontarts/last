package com.frontarts.tiger.collections;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA. @3/7/14 2:39 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class SetTest {

    private final String[] strings = new String[]{"i", "came", "i", "saw", "i", "left"};
    private final String[] otherStrings = new String[]{"i", "eat", "i", "dance", "i", "play"};

    @Test
    public void findDups() {

        Set<String> set = new HashSet<String>();
        for (String string : strings) {
            if (!set.add(string)) {
                System.out.println("duplicate detected:" + string);
            }
        }
        System.out.println(set.size() + " distinct words" + set);
    }

    @Test
    public void findDups2() {

        Set<String> unique = new HashSet<String>();
        Set<String> dups = new HashSet<String>();
        for (String string : strings)
            if (!unique.add(string)) dups.add(string);
        unique.removeAll(dups);
        System.out.println("unique words: " + unique);
        System.out.println("duplicate words: " + dups);
    }

    @Test
    public void symmetricDiff(){
        Set<String> symmetricDiff = new HashSet<String>(Arrays.asList(strings));
        symmetricDiff.addAll(Arrays.asList(otherStrings));
        Set<String> intersection = new HashSet<String>(Arrays.asList(strings));
        intersection.retainAll(Arrays.asList(otherStrings));
        symmetricDiff.removeAll(intersection);
        System.out.println(symmetricDiff);
    }

}
