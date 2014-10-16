package com.frontarts.thread;

/**
 * Created by IntelliJ IDEA. @7/24/2014 10:29 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Drop {

    private String message;
    private boolean empty = true;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message){
        while (!empty){
            try{
                wait();
            } catch (InterruptedException ex){}
        }

        empty=false;
        this.message = message;
        notifyAll();
    }

}
