package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    //    public static final int AC_CATE=10;
    public static List<Device> AC_CATEGORY = new ArrayList<Device>();

    static {
        AC1 = new AirConditioner();
        AC1.setId("ELT0001");
        AC1.setPower("1180");
        AC1.setType(ELTC_AWY);
        AC_CATEGORY.add(AC1);

        AC2 = new AirConditioner();
        AC2.setId("ELT0002");
        AC2.setPower("1480");
        AC2.setType(ELTC_AWY);
        AC_CATEGORY.add(AC2);

        AC3 = new AirConditioner();
        AC3.setId("ELT0003");
        AC3.setPower("1780");
        AC3.setType(ELTC_AWY);
        AC_CATEGORY.add(AC3);

        AC4 = new AirConditioner();
        AC4.setId("ELT0004");
        AC4.setPower("1280");

        AC4.setType(ELTC_AWY);

        AC_CATEGORY.add(AC4);

        AC5 = new AirConditioner();
        AC5.setId("ELT0005");
        AC5.setPower("1380");
        AC5.setType(ELTC_AWY);

        AC_CATEGORY.add(AC5);

        AC6 = new AirConditioner();
        AC6.setId("ELT0006");
        AC6.setPower("1580");
        AC6.setType(ELTC_AWY);

        AC_CATEGORY.add(AC6);

        AC7 = new AirConditioner();
        AC7.setId("ELT0007");
        AC7.setPower("1880");
        AC7.setType(ELTC_AWY);

        AC_CATEGORY.add(AC7);

        AC8 = new AirConditioner();
        AC8.setId("ELT0008");
        AC8.setPower("3000");
        AC8.setType(ELTC_AWY);

        AC_CATEGORY.add(AC8);

        AC9 = new AirConditioner();
        AC9.setId("ELT0009");
        AC9.setPower("2400");
        AC9.setType(ELTC_AWY);

        AC_CATEGORY.add(AC9);

        AC10 = new AirConditioner();
        AC10.setId("ELT0010");
        AC10.setPower("2700");
        AC10.setType(ELTC_AWY);

        AC_CATEGORY.add(AC10);

    }


    public static int[] getSampleByUserType(UserType type) {
        switch (type) {
            case TYPEA:
                return new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17};
            case TYPEB:
                return new int[]{18, 19, 20, 21, 22, 23, 0};
            case TYPEC:
                return new int[]{18, 19, 20, 21, 22, 23, 0,1,2,3,4,5,6,7,8};
            case TYPED:
                return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
            default:
                return new int[]{0};
        }
    }

    public AirConditioner getRandomAC() {
        Random random = new Random();
        return (AirConditioner) AC_CATEGORY.get(random.nextInt(AC_CATEGORY.size() - 1));

    }


}
