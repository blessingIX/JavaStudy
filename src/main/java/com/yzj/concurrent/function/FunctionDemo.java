package com.yzj.concurrent.function;

import java.util.function.Function;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 11:16
 */
public class FunctionDemo {

    /*
    函数型接口
     */

    public static void main(String[] args) {

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("function"));

    }

}
