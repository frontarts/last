package com.frontarts.tiger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA @ 11/18/11 11:55 AM
 * Copyright © 1994-2011. EMC Corporation.  All Rights Reserved.
 *
 * @author wangy23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TTest {
}
