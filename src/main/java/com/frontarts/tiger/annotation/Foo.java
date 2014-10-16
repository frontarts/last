package com.frontarts.tiger.annotation;

/**
 * Created with IntelliJ IDEA @ 11/18/11 12:01 PM
 * Copyright © 1994-2011. EMC Corporation.  All Rights Reserved.
 *
 * @author wangy23
 */
public class Foo {
    @TTest
    public void testMethod1() {
    }

    @TTest
    public void testMethod2() {
    }

    @TTest
    public void testMethod3() {
        throw new RuntimeException("case failed");
    }

    @TTest
    public void testMethod4() {
    }

}
