package com.frontarts.thread;

import java.util.Random;

/**
 * Created by IntelliJ IDEA. @7/24/2014 11:17 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for(String message = drop.take();!message.equals("DONE");message=drop.take()){
            System.out.printf("MESSAGE RECEIVED: %s%n", message);
            try{
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {

            }
        }

    }
}
