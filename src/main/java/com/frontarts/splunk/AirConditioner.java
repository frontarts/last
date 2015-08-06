package com.frontarts.splunk;

/**
 * Created by IntelliJ IDEA. @8/5/2015 11:58 PM
 * Author: Y
 * Copyright ? 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class AirConditioner extends Device {
    public static final AirConditioner AC1;
    public static final AirConditioner AC2;
    public static final AirConditioner AC3;
    public static final AirConditioner AC4;
    public static final AirConditioner AC5;
    public static final AirConditioner AC6;
    public static final AirConditioner AC7;
    public static final AirConditioner AC8;
    public static final AirConditioner AC9;
    public static final AirConditioner AC10;

    static {
        AC1 = new AirConditioner();
        AC1.setId("ELT0001");
        AC1.setPower("1180");

        AC2 = new AirConditioner();
        AC2.setId("ELT0002");
        AC2.setPower("1480");

        AC3 = new AirConditioner();
        AC3.setId("ELT0003");
        AC3.setPower("1780");

        AC4 = new AirConditioner();
        AC4.setId("ELT0004");
        AC4.setPower("1280");

        AC5 = new AirConditioner();
        AC5.setId("ELT0005");
        AC5.setPower("1380");

        AC6 = new AirConditioner();
        AC6.setId("ELT0006");
        AC6.setPower("1580");

        AC7 = new AirConditioner();
        AC7.setId("ELT0007");
        AC7.setPower("1880");

        AC8 = new AirConditioner();
        AC8.setId("ELT0008");
        AC8.setPower("3000");

        AC9 = new AirConditioner();
        AC9.setId("ELT0009");
        AC9.setPower("2400");

        AC10 = new AirConditioner();
        AC10.setId("ELT0010");
        AC10.setPower("2700");

    }





}
