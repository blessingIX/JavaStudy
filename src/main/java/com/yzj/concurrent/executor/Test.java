package com.yzj.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 14:08
 */
public class Test {
    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SumTask task = new SumTask(i * 100 + 1, (i + 1) * 100);
            Future<Integer> future = executor.submit(task);
            list.add(future);
        }

        while (executor.getCompletedTaskCount() < list.size()) {
            System.out.println("CompletedTaskCount: " + executor.getCompletedTaskCount());
//            for (Future<Integer> future:list) {
//                System.out.println(future.isDone());
//            }
            try {
                TimeUnit.SECONDS.sleep(1);  // 单位：秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int total = 0;
        for (Future<Integer> future:list) {
            try {
                total += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("total: " + total);
        executor.shutdown();
    }
}
