package com.yzj.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @description: 比较三种方式从1到10_0000_0000累加效率（for、ForkJoin、Stream）
 * @author: 易子建
 * @create: 2020-10-27 20:28
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        forLoop();
        forkJoin();
        stream();

    }

    public static void forLoop() {

        long sum = 0L;  // 给为Long类型：10701ms
        long start = System.currentTimeMillis();

        for (long i = 1L; i <= 10_0000_0000L; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();
        System.out.printf("sum=%d, for: %dms\n", sum, end - start);

    }

    public static void forkJoin() throws ExecutionException, InterruptedException {
        // fixme: fork join 方式比for更慢？

        long sum = 0L;
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new ForkJoinDemo(1, 10_0000_0000));
        sum = submit.get();


        long end = System.currentTimeMillis();
        System.out.printf("sum=%d, fork join: %dms\n", sum, end - start);

    }

    public static void stream() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000L)
                .parallel() // 去掉parallel会降低效率（慢到比for循环还慢），why？
                .reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.printf("sum=%d, stream: %dms\n", sum, end - start);
    }

}

class ForkJoinDemo extends RecursiveTask<Long> {
    // todo: 看kuang

    private static final long HOLD = 1000;  // 10000: 1703ms | 1000: 1593ms | 100: 1781ms
    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if ((end - start) <= HOLD) {
            long res = 0;
            for (long i = start; i <= end; i++) {
                res += i;
            }
            return res;
        } else {
            long mid = start + (end - start >> 2);
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            ForkJoinDemo task2 = new ForkJoinDemo(mid + 1, end);
            return task1.compute() + task2.compute();
        }

    }
}