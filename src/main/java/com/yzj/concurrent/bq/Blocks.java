package com.yzj.concurrent.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-24 17:19
 */
public class Blocks {

    /*
                Blocks
    insert      put(e)
    remove      take()
    examine     not applicable
     */

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d"); // 一直阻塞，直到队列中有空位，再把值存入队列
        System.out.println("=========");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());   // 一直阻塞，直到队列中元素，再值取出

    }

}
