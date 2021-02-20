package com.yzj.concurrent.pool;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 09:58
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

//        threadPoolExecutor(new ThreadPoolExecutor.AbortPolicy(), 2);
//        threadPoolExecutor(new ThreadPoolExecutor.AbortPolicy(), 5);
//        threadPoolExecutor(new ThreadPoolExecutor.AbortPolicy(), 8);
//        threadPoolExecutor(new ThreadPoolExecutor.AbortPolicy(), 9);

//        threadPoolExecutor(new ThreadPoolExecutor.CallerRunsPolicy(), 2);
//        threadPoolExecutor(new ThreadPoolExecutor.CallerRunsPolicy(), 5);
//        threadPoolExecutor(new ThreadPoolExecutor.CallerRunsPolicy(), 8);
//        threadPoolExecutor(new ThreadPoolExecutor.CallerRunsPolicy(), 9);

//        threadPoolExecutor(new ThreadPoolExecutor.DiscardPolicy(), 9);

//        threadPoolExecutor(new ThreadPoolExecutor.DiscardOldestPolicy(), 9);

//        cpu(20);
    }

    public static void threadPoolExecutor(RejectedExecutionHandler handler, int n) {

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                handler
        );

        try {
            for (int i = 0; i < n; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } finally {
            threadPool.shutdown();
        }

    }

    public static void cpu(int n) {

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors() * 2,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i < n; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } finally {
            threadPool.shutdown();
        }

    }

}
