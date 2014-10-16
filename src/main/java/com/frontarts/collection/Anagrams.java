package com.frontarts.collection;

import java.util.*;

/**
 * Created by IntelliJ IDEA. @5/7/14 3:40 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Anagrams {

    public void test() {

        Map<String, List<String>> m = new HashMap<String, List<String>>();
        List<String> input = new ArrayList<String>();

        Iterator<String> it = input.iterator();
        while (it.hasNext()) {
            String word = it.next();
            String alpha = alphabetize(word);
            List<String> list = m.get(alpha);
            if (list == null) m.put(alpha, list = new ArrayList<String>());

        }

        for(List<String> l : m.values()){

        }

    }

    public String alphabetize(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }
}
