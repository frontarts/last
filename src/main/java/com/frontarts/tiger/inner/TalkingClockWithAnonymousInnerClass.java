package com.frontarts.tiger.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by IntelliJ IDEA. @2/22/12 3:26 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved. A custom Spring
 */
public class TalkingClockWithAnonymousInnerClass {
    
    public void start(int interval, final boolean beep){
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("@ the tone, the time is " + now);
                if(beep) System.out.println("We are beeping...");
            }
        };
    }
}
