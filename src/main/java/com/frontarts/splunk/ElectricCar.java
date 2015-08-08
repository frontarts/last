package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public static List<Device> EL_CAR_CATEGORY=new ArrayList<Device>();

   static  {
       CAR1 = new ElectricCar();
       CAR1.setId("CHR0001");
       CAR1.setPower("11000");
       CAR1.setCapacity("70000");
       CAR1.setType("CHARGER");
       EL_CAR_CATEGORY.add(CAR1);

       CAR2 = new ElectricCar();
       CAR2.setId("CHR0002");
       CAR2.setPower("2800");
       CAR2.setCapacity("13000");
       CAR2.setType("CHARGER");
       EL_CAR_CATEGORY.add(CAR2);

       CAR3 = new ElectricCar();
       CAR3.setId("CHR0003");
       CAR3.setPower("3000");
       CAR3.setCapacity("8700");
       CAR3.setType("CHARGER");
       EL_CAR_CATEGORY.add(CAR3);
       
       CAR4 = new ElectricCar();
       CAR4.setId("CHR0004");
       CAR4.setPower("3500");
       CAR4.setCapacity("30400");
       CAR4.setType("CHARGER");
       EL_CAR_CATEGORY.add(CAR4);

    }

    @Override
    protected int getFrequency() {
        return 5;
    }

    public ElectricCar getRandomELCars(){
             Random random = new Random();
             return (ElectricCar) EL_CAR_CATEGORY.get(random.nextInt(EL_CAR_CATEGORY.size()-1));

       }

}
