package com.yzj.concurrent.pool;

import java.util.concurrent.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 09:47
 */
public class MyThreadPoolExecutor {

    /*
    线程池七大参数
     */

    public MyThreadPoolExecutor(int corePoolSize,     // 核心线程池大小
                                int maximumPoolSize,  // 最大核心线程池大小
                                long keepAliveTime,   // 超时未调用释放时间
                                TimeUnit unit,        // 超时单位
                                BlockingQueue<Runnable> workQueue,    // 阻塞队列
                                ThreadFactory threadFactory,          // 线程工程，用于创建线程
                                RejectedExecutionHandler handler) {   // 拒绝策略

    }

}
