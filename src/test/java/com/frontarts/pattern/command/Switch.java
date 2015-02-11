package com.frontarts.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the invoker class, the invoker class can also be hold all the possible command by a hashmap comply the
 * data-driven pattern.
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Switch {

    private List<Command> history = new ArrayList<Command>();

    public void storeAndExecute(Command cmd) {
        this.history.add(cmd);
        cmd.execute();
    }
}
