package com.yzj.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 15:23
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(1, 100000000);

        ForkJoinTask<Long> res = pool.submit(task);

        while (!task.isDone()) {
            System.out.println(pool.getActiveThreadCount());
            System.out.println(pool.getParallelism());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(res.get().toString());
    }
}
