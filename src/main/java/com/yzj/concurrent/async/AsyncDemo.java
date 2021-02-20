package com.yzj.concurrent.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-29 10:02
 */
public class AsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        asyncVoid();
        asyncReturn();

    }

    public static void asyncVoid() throws ExecutionException, InterruptedException {

        System.out.println("=====asyncVoid=====");
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("awake");
        });

        System.out.println("before get");
        completableFuture.get();
        System.out.println("after get");

    }

    public static void asyncReturn() throws ExecutionException, InterruptedException {

        System.out.println("=====asyncReturn=====");
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 1024;
        });

        System.out.println("before get");
        System.out.println(completableFuture.whenComplete((u, v) -> {
            System.out.println("u = " + u); // 正确的返回结果
            System.out.println("v = " + v); // 发生异常时的错误信息
        }).exceptionally((e) -> {
            System.out.println("e.getMessage() = " + e.getMessage());   // e: 异步回调中产生的异常
            return 500; // 发生异常时的返回结果
        }).get());
        System.out.println("after get");

    }

}
