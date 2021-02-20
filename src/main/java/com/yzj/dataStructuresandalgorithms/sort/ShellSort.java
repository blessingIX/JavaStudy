package com.yzj.dataStructuresandalgorithms.sort;

import java.util.Arrays;

/**
 * @description: 希尔排序
 * @author: 易子建
 * @create: 2020-11-07 10:56
 */
public class ShellSort {

    public static void sort(int[] array) {
        int d = array.length;
        while (d > 1) {
            d = d / 2;  //
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {  // 此处基本和插入排序思想一致，只是步长不是固定为1罢了
                    int temp = array[i];
                    int j = i - d;
                    for (; j >= 0 && array[j] > temp; j = j - d) {  // 相当于插入排序中从后往前插入的过程，只不过步长不一定是1
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 0, 4, 3, 7, 0, 9, 5};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

}
