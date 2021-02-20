package com.yzj.concurrent.function;

import java.util.function.Predicate;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 11:20
 */
public class PredicateDemo {

    /*
    断定型接口
     */

    public static void main(String[] args) {

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));

    }

}
