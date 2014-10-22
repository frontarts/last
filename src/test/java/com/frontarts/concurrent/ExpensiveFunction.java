package com.frontarts.concurrent;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA. @10/21/2014 11:09 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
