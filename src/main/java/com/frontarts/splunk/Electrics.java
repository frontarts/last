package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA. @8/6/2015 12:29 AM
 * Author: Y
 * Copyright ? 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Electrics extends Device {

    public static final Electrics WATER_HEATER1;
    public static final Electrics WATER_HEATER2;
    public static final Electrics HOME_THEATER1;
    public static final Electrics HOME_THEATER2;
    public static final Electrics LAUNDRY_MACHINE1;
    public static final Electrics LAUNDRY_MACHINE2;
    public static List<Device> ELT_CATEGORY = new ArrayList<Device>();

    static {
        WATER_HEATER1 = new Electrics();
        WATER_HEATER1.setId("ELT0101");
        WATER_HEATER1.setPower("3000");
        WATER_HEATER1.setType(ELTC_CNT);
        ELT_CATEGORY.add(WATER_HEATER1);

        WATER_HEATER2 = new Electrics();
        WATER_HEATER2.setId("ELT0102");
        WATER_HEATER2.setPower("4000");
        WATER_HEATER2.setType(ELTC_CNT);
        ELT_CATEGORY.add(WATER_HEATER2);

        HOME_THEATER1 = new Electrics();
        HOME_THEATER1.setId("ELT0103");
        HOME_THEATER1.setPower("200");
        HOME_THEATER1.setType(ELTC_DUR);
        ELT_CATEGORY.add(HOME_THEATER1);

        HOME_THEATER2 = new Electrics();
        HOME_THEATER2.setId("ELT0104");
        HOME_THEATER2.setPower("500");
        HOME_THEATER2.setType(ELTC_DUR);
        ELT_CATEGORY.add(HOME_THEATER2);

        LAUNDRY_MACHINE1 = new Electrics();
        LAUNDRY_MACHINE1.setId("ELT0105");
        LAUNDRY_MACHINE1.setPower("2480");
        LAUNDRY_MACHINE1.setType(ELTC_CNT);
        ELT_CATEGORY.add(LAUNDRY_MACHINE1);

        LAUNDRY_MACHINE2 = new Electrics();
        LAUNDRY_MACHINE2.setId("ELT0106");
        LAUNDRY_MACHINE2.setPower("3500");
        LAUNDRY_MACHINE2.setType(ELTC_CNT);
        ELT_CATEGORY.add(LAUNDRY_MACHINE2);
    }

    public Electrics getRandomELT() {
        Random random = new Random();
        return (Electrics) ELT_CATEGORY.get(random.nextInt(ELT_CATEGORY.size() - 1));

    }


}
