package com.frontarts.splunk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @8/5/2015 11:37 PM
 * Author: Y
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class User {

    private String id;
    private String address;
    public List<Device> devices = new ArrayList<Device>();
    public List<Device> rtDevices= new ArrayList<Device>();
    private UserType type;

    public User(){

    }

    public User(String id){
        this.id=id;
    }

    public void addDevice(Device device){
        devices.add(device);
    }

    public void addRtDevice(Device device){
        rtDevices.add(device);
    }

    public void setId(String id){
        this.id = id;
    }

    public String  getId(){
        return this.id;
    }

    public UserType getUserType(){
        return this.type;
    }

    public void setUserType(UserType type){
        this.type = type;
    }
}
