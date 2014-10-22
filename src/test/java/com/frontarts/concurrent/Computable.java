package com.frontarts.concurrent;

/**
 * Created by IntelliJ IDEA. @10/21/2014 11:05 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public interface Computable<A,V> {

    V compute(A arg) throws InterruptedException;
}
