package com.yzj.concurrent.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-24 17:01
 */
public class ThrowsException {

    /*
            Throws exceptions
    insert      add(e)
    remove      remove()
    examine     element()
     */

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d")); // java.lang.IllegalStateException: Queue full
        System.out.println("===============");
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); // java.util.NoSuchElementException

    }

}
