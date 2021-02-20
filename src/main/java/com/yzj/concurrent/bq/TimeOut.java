package com.yzj.concurrent.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-24 17:26
 */
public class TimeOut {

    /*
                Time out
    insert      offer(e, time, unit)
    remove      poll(time, unit)
    examine     not applicable
     */

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 1, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 1, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 1, TimeUnit.SECONDS));  // false，队列满时，最多等待一段时间，一段时间内没有空位，入队s失败
        TimeUnit.SECONDS.sleep(2);
        System.out.println("==========");
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS)); // null，队列无资源时等待，最多等待一段时间，一段时间后未未获得资源，返回null

    }

}
