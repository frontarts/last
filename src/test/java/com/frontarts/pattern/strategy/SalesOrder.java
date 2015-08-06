package com.frontarts.pattern.strategy;

/**
 * Created by IntelliJ IDEA. @1/21/2015 4:35 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class SalesOrder {
    public void process(CalculateTax myTax) {
        long itemNumber = 0;
        double price = 0;
        double tax = myTax.taxAmount(itemNumber,price);

    }
}
