package com.yzj.concurrent.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-24 17:09
 */
public class SpecialValue {

    /*
            Special value
    inset       offer(e)
    remove      poll()
    examine     peek()
     */

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));   // false, 无法入队
        System.out.println("==========");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll()); // null
    }

}
