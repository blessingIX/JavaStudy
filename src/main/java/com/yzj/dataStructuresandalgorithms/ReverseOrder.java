package com.yzj.dataStructuresandalgorithms;

import java.util.Arrays;

/**
 * @program: JavaStudy
 * @description: 利用分治算法计算数据的逆序度
 * @author: blessing
 * @create: 2020-05-27 11:40
 */
public class ReverseOrder {
    private int count;

    public int reverseOrderCount(int[] array) {
        count = 0;
        mergeSortCount(array, 0 , array.length - 1);
        return count;
    }

    private void mergeSortCount(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            mergeSortCount(array, start, mid);
            mergeSortCount(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid + 1;
        int p  = 0;
        int[] tmp = new int[end - start + 1];
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                tmp[p++] = array[p1++];
            } else {
                count += (end - p2 + 1);
                tmp[p++] = array[p2++];
            }
        }
        while (p1 <= mid) { // 处理剩下的
            tmp[p++] = array[p1++];
        }
        while (p2 <= end) { // 处理剩下的
            tmp[p++] = array[p2++];
        }
        for (p1 = 0; p1 <= end - start; p1++) { // 从tmp拷贝回array
            array[start + p1] = tmp[p1];
        }
    }

    public static void main(String[] args){
        ReverseOrder reverseOrder = new ReverseOrder();
//        FIXME: case [6,5,4,3,2,1] 逆序度错误
        int[] arr = new int[]{6,5,4,3,2,1};
        int[] original = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr) + "的逆序度：" + reverseOrder.reverseOrderCount(arr));
        System.out.println(Arrays.toString(original) + "---归并排序-->" + Arrays.toString(arr));
    }
}
