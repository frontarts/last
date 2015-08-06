package com.frontarts.splunk;

/**
 * Created by IntelliJ IDEA. @8/5/2015 11:37 PM
 * Author: Y
 * Copyright ? 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Device {

    private String id;
    private String name;
    private String power;
    private String type;

    public String getChargePower() {
        return chargePower;
    }

    public void setChargePower(String chargePower) {
        this.chargePower = chargePower;
    }


    /* ====================Chargeble Devices =============================*/
    private String chargePower;

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
