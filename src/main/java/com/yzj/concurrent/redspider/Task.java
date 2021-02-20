package com.yzj.concurrent.redspider;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-16 17:42
 */
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }
}
