package com.frontarts.thread;

/**
 * Created by IntelliJ IDEA. @7/22/2014 11:21 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class SleepThreads {

    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName,message);

    }

    private static class MessageLoop implements Runnable{

        public void run() {
            String messages[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (String message : messages) {
                try {
                    Thread.sleep(4*1000);
                    threadMessage(message);
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done!");
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        long patience = 1000*60*60;
        if(args.length>0){
            try{
                patience = Long.parseLong(args[0])*1000;
            }catch(NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }

            threadMessage("Starting MessageLoop thread");
            long startTime = System.currentTimeMillis();
            Thread t = new Thread(new MessageLoop());
            t.start();

            while (t.isAlive()){
                threadMessage("Still waiting...");
                t.join(1000);
                if((System.currentTimeMillis()-startTime>patience)&&t.isAlive())threadMessage("Thired of waiting!");
                t.interrupt();
                t.join();
            }
        }

 }

}

