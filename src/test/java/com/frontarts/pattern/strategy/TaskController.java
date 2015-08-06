package com.frontarts.pattern.strategy;

/**
 * Created by IntelliJ IDEA. @1/21/2015 4:33 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TaskController {

    public void process(){
        CalculateTax myTax;
        myTax = getTaxResultForCountry();
        SalesOrder order = new SalesOrder();
        order.process(myTax);
    }

    private CalculateTax getTaxResultForCountry() {
        return null;
    }


}
