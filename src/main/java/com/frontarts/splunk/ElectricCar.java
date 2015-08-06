package com.frontarts.splunk;

/**
 * Created by IntelliJ IDEA. @8/6/2015 12:23 AM
 * Author: Y
 * Copyright ? 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class ElectricCar extends Device {
    public static final ElectricCar CAR1;
    public static final ElectricCar CAR2;
    public static final ElectricCar CAR3;
    public static final ElectricCar CAR4;
   static  {
       CAR1 = new ElectricCar();
       CAR1.setId("CHR0001");
       CAR1.setPower("70000");
       CAR1.setChargePower("11000");
       CAR1.setType("CHARGER");

       CAR2 = new ElectricCar();
       CAR2.setId("CHR0002");
       CAR2.setPower("13000");
       CAR2.setChargePower("2800");
       CAR2.setType("CHARGER");

       CAR3 = new ElectricCar();
       CAR3.setId("CHR0003");
       CAR3.setPower("8700");
       CAR3.setChargePower("2800");
       CAR3.setType("CHARGER");
       
       CAR4 = new ElectricCar();
       CAR4.setId("CHR0004");
       CAR4.setPower("30400");
       CAR4.setChargePower("2800");
       CAR4.setType("CHARGER");

    }

    @Override
    protected int getFrequency() {
        return 5;
    }
}
