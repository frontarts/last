package com.frontarts.tiger.inner;

import com.frontarts.tiger.generics.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by IntelliJ IDEA. @2/22/12 2:17 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved. A custom Spring
 */
public class TalkingClock {
    private static String something;
    private String name;

    //inner class in a method, which is completely invisible to other class;
    // could access final method parameters(beep in this case)
    public void start(int interval, final boolean beep) {
        int local=0;
        class TimePrinter implements ActionListener {
          static final int shit = 10;
            public void actionPerformed(ActionEvent e) {

                TalkingClock.something = "shit";
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) System.out.println("we are beeping...");

            }
        }

        ActionListener listener = new TimePrinter();

        Timer t = new Timer(interval, listener);
        t.start();

    }
    public static class Inner {
        public Inner(){

        }

        private void testMethod(){

        }

    }

}
