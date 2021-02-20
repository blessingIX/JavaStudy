package com.yzj.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 15:13
 */
public class SumTask extends RecursiveTask<Long> {
    private int start;
    private int end;

    public static final int hold = 10;

    public SumTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0L;

        if ((end - start) < hold) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int mid = start + (end - start) / 2;
            SumTask task1 = new SumTask(start, mid);
            SumTask task2 = new SumTask(mid + 1, end);

            invokeAll(task1, task2);

            Long sum1 = task1.join();
            Long sum2 = task2.join();
            sum = sum1 + sum2;
        }

        return sum;
    }
}
