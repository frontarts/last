package com.frontarts.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA. @10/21/2014 11:15 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Memoizer<A, V> implements Computable<A, V> {

    // 1, use ConcurrentHashMap to avoid blocking compute();
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> fTask = new FutureTask<V>(eval);
            future = fTask;
            cache.put(arg, future);
            fTask.run();
            future = cache.putIfAbsent(arg, fTask);
            fTask.run();
        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            throw new InterruptedException(e.getMessage());
        }
    }
}
