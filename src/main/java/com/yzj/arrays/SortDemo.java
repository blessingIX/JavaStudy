package com.yzj.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-30 11:16
 */
public class SortDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,5,0,4,3,7,0,9,5};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        Integer[] a = new Integer[]{1,3,5,0,4,3,7,0,9,5};
        List<Integer> list = Arrays.asList(a);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
