package com.frontarts.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA. @7/24/2014 3:57 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class SafeLock {

    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock();

        Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (!(myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }

            return myLock && yourLock;
        }

        public void bow(Friend bower) {
            if (impendingBow(bower)) {
                try {
                    System.out.printf("%s: %s has" + " bowed to me!%n", this.name, bower.getName());
                } finally {
                    lock.unlock();
                    bower.lock.unlock();
                }

            } else {
                System.out.printf("%s: %s started to bow to me, but saw that I was already bowing to him%n",
                        this.name, bower.getName());
            }
        }
    }

    static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            for (; ; ) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException ex) {
                }
                bowee.bow(bower); // why in the catch clasue

            }

        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }

}
