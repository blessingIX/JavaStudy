package com.yzj.concurrent.executor;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 14:13
 */
public class SumTask implements Callable<Integer> {
    private Integer start;
    private Integer end;

    public SumTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        Thread.sleep(random.nextInt(10000));
        return sum;
    }
}
