package com.frontarts.pattern.command;

/**
 * Created by IntelliJ IDEA. @1/21/2015 2:27 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class PressSwitch {

    public static void main(String[] args) {
        Light lamp = new Light();
        Command switchUp = new FlipUpCommand(lamp);
        Command switchDown = new FlipDownCommand(lamp);

        Switch mySwitch = new Switch();
        try {
            if ("ON".equals(args[0])) {
                mySwitch.storeAndExecute(switchUp);
            }
        } catch (Exception e) {
            System.out.println("Arguments required");
        }

    }
}
