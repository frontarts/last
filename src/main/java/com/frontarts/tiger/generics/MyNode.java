package com.frontarts.tiger.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @8/21/12 11:02 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
        ppField = "shit";
    }

    @Override
    public void setData(Integer data) {
        super.setData(data);
    }

    public static void main(String[] args) {
//        MyNode myNode = new MyNode(5);
//        Node node = myNode;
//        node.setData("shit");
//
//        Integer x = myNode.data;
//
//        List<Object> objList = new ArrayList<Object>();
//        List<String> strList = new ArrayList<String>();
//        strList = (List<String>) objList;
//        objList = (List<Object>) strList;
//        objList.add(new Integer(9));
        System.out.printf("%08x\n", 1);
    }
}
