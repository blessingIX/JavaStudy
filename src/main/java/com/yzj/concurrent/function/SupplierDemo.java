package com.yzj.concurrent.function;

import java.util.function.Supplier;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 11:25
 */
public class SupplierDemo {

    /*
    供给型接口
     */

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());

    }

}
