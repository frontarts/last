package com.frontarts.tiger.annotation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA @ 11/18/11 12:03 PM
 * Copyright © 1994-2011. EMC Corporation.  All Rights Reserved.
 *
 * @author wangy23
 */
public class TAnnotation {

    int passed;
    int failed;

    @Test
    public void testMyAnnotation() {
        try {
            Object foo = Class.forName("com.frontarts.tiger.annotation.Foo").newInstance();
            for (Method m : foo.getClass().getDeclaredMethods()) {
                if (m.isAnnotationPresent(TTest.class)) {
                    try {
                        m.invoke(foo);
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                        failed++;
                    }
                }

            }
        } catch (ClassNotFoundException e) {
            Assert.fail(e.getMessage());
        } catch (InstantiationException e) {
            Assert.fail(e.getMessage());
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, failed);
    }


}
