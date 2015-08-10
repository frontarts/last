package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @8/5/2015 11:37 PM
 * Author: Y
 * Copyright ? 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Device {
    public static final String CHARGER="CHAG";
    public static final String ELTC_DUR="ELTC-DUR";
    public static final String ELTC_AWY="ELTC-AWY";
    public static final String ELTC_CNT="ELTC-CNT";


    private String id;
    private String name;
    private String power;
    private String type;
    private List<Device> categories = new ArrayList<Device>(){};
    protected void addCategory(Device device){
        categories.add(device);
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String chargePower) {
        this.capacity = chargePower;
    }


    /* ====================Chargeble Devices =============================*/
    private String capacity;

    /* ====================== to be override =============================*/
    protected int getFrequency() {
        return 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
