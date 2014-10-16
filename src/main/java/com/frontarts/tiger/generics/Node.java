package com.frontarts.tiger.generics;

/**
 * Created by IntelliJ IDEA. @8/21/12 11:01 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

  protected   String ppField;
}
