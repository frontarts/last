package com.frontarts.pattern.command;

/**
 * Created by IntelliJ IDEA. @1/20/2015 11:36 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class FlipUpCommand implements Command {

    private Light light;

    public FlipUpCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {

        this.light.turnOn();
    }
}
