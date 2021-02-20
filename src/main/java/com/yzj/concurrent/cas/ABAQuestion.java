package com.yzj.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-29 14:49
 */
public class ABAQuestion {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2020);

        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2020, 2333));
        System.out.println(atomicInteger.get());

    }

}
