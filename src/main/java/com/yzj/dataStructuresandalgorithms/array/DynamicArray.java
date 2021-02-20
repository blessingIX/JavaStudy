package com.yzj.dataStructuresandalgorithms.array;

/**
 * @program: JavaStudy
 * @description: 支持动态扩容的数组
 * @author: blessing
 * @create: 2020-06-04 17:44
 */
public class DynamicArray<E> {
    private E[] data;
    private int capacity = 10;
    private int size;

    public DynamicArray() {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E e) {
        if (isFull()) resize();
        data[size] = e;
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public E remove(int index) {
        checkIndex(index);
        E e = this.get(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return e;
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    public void clear() {
        size = 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private void resize() {
        capacity = capacity * 3 / 2;
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) stringBuilder.append( ", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray.size());

        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
        for (int i = 0; i < dynamicArray.size; i++) {
            System.out.print(dynamicArray.get(i) + " ");
        }
        System.out.println();
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.capacity);

        System.out.println(dynamicArray);

        DynamicArray<Boolean> da = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            da.add(i % 2 == 0);
        }
        System.out.println(da);

//        System.out.println(da.get(da.size()));

        System.out.println(dynamicArray.remove(3));
        System.out.println(dynamicArray);
//        System.out.println(dynamicArray.remove(-1));

        da.clear();
        System.out.println(da);

        dynamicArray.set(1, 10);
        System.out.println(dynamicArray);
    }
}
