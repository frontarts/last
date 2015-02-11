package com.frontarts.pattern.strategy;

/**
 * Created by IntelliJ IDEA. @1/21/2015 4:34 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public interface CalculateTax {

    public double taxAmount(long itemNumber, double price);

}
