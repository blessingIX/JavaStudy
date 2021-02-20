package com.yzj.dataStructuresandalgorithms.heap;

import java.util.Arrays;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-07-02 10:32
 */
public class Heap {
    private int[] data;
    private int count;
    private int capacity;

    public Heap(int capacity) {
        this.data = new int[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public void insert(int val) {
        if (count >= capacity) return;
        data[++count] = val;
        int i = count;
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(data, i, i / 2);
            i /= 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int[] data, int i, int n) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && data[i] < data[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && data[maxPos] < data[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(data, i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap() {
        for (int i = count / 2; i >= 1; i--) {
            heapify(data, i, count);
        }
    }

    public void sort() {
        buildHeap();
        int k = count;
        while (k > 1) {
            swap(data, 1, k--);
            heapify(data, 1, k);
        }
    }

    public void removeMax() {
        if (count == 0) return;
        data[1] = data[count--];
        heapify(data, 1, count);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 1; i < count + 1; i++) {
            stringBuilder.append(data[i]);
            if (i == count) stringBuilder.append("]");
            else stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] ls = new int[]{1,3,5,0,4,3,7,0,9,5};
        Heap heap = new Heap(ls.length);
        for (int l : ls) {
            heap.insert(l);
        }
        heap.insert(10);
        System.out.println(Arrays.toString(heap.data));
        heap.removeMax();
        heap.removeMax();
        heap.removeMax();
        System.out.println(heap);
        System.out.println(heap.count);
    }
}
