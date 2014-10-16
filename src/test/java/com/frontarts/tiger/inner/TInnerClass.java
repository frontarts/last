package com.frontarts.tiger.inner;

import org.testng.annotations.Test;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA. @2/22/12 2:23 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved. A custom Spring
 */
public class TInnerClass {
    @Test
    public void testLocalInnerClass() {

        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit ?");
        System.exit(0);
//        new TalkingClock(1000,true).TimePrinter();

//        TalkingClock jabberer = new TalkingClock(10,false);
//        TalkingClock.TimePrinter innerRef =jabberer.new TimePrinter();


    }

    @Test
    public void testAnonymousInnerClass(){
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
    }

}
