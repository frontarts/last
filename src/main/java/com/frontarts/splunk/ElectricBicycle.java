package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wangy23 on 8/6/15.
 */
public class ElectricBicycle extends Device {
    public static final ElectricBicycle BICYCLE1;
    public static final ElectricBicycle BICYCLE2;
    public static final ElectricBicycle BICYCLE3;
    public static List<Device> EL_BICYCLE_CATEGORY=new ArrayList<Device>();

   static  {
       BICYCLE1 = new ElectricBicycle();
       BICYCLE1.setId("CHR1001");
       BICYCLE1.setPower("260");
       BICYCLE1.setCapacity("1560");
       BICYCLE1.setType(CHARGER);
       EL_BICYCLE_CATEGORY.add(BICYCLE1);

       BICYCLE2 = new ElectricBicycle();
       BICYCLE2.setId("CHR1002");
       BICYCLE2.setPower("300");
       BICYCLE2.setCapacity("1180");
       BICYCLE2.setType(CHARGER);
       EL_BICYCLE_CATEGORY.add(BICYCLE2);

       BICYCLE3 = new ElectricBicycle();
             BICYCLE3.setId("CHR1003");
             BICYCLE3.setPower("300");
             BICYCLE3.setCapacity("1180");
       BICYCLE3.setType(CHARGER);
             EL_BICYCLE_CATEGORY.add(BICYCLE3);



    }

    @Override
    protected int getFrequency() {
        return 1;
    }

    public ElectricBicycle getRandomELCBicycle(){
             Random random = new Random();
             return (ElectricBicycle) EL_BICYCLE_CATEGORY.get(random.nextInt(EL_BICYCLE_CATEGORY.size()-1));

       }

}