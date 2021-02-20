package com.yzj.concurrent.function;

import java.util.function.Consumer;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 11:23
 */
public class ConsumerDemo {

    /*
    消费型接口
     */

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        consumer.accept("consumer");

    }

}
