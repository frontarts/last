package com.frontarts.splunk;

import java.math.BigDecimal;

/**
 * Created by wangy23 on 8/6/15.
 */
public class TT {
    public static void main(String[] args) {
        BigDecimal capacity = new BigDecimal("1180");
        BigDecimal power = new BigDecimal("300");
        String duration = capacity.divide(power,3, BigDecimal.ROUND_CEILING).multiply(new BigDecimal("60")).setScale(0, BigDecimal.ROUND_CEILING).toString();
       String consumption = capacity.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_CEILING).setScale(2,BigDecimal.ROUND_CEILING).toString();

        System.out.println(duration);
        System.out.println(consumption);

    }
}
