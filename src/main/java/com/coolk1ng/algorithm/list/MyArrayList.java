package com.coolk1ng.algorithm.list;

/**
 * 数组操作
 * @author coolk1ng
 * @since 2023/3/10 16:33
 */
public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 数组新增
     */
    public void insert(int element, int index) {
        //下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组范围...");
        }

        //扩容
        if (size >= array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    /**
     * 数组删除
     */
    public int remove(int index) {
        //下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组范围...");
        }

        //删除的元素
        int deleteElement = array[index];

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }

        size --;
        return deleteElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 输出数组
     */
    public void outPut() {
        for (int i : array) {
            System.out.println(i);
        }
    }

    //测试
    public static void main(String[] args) {
        MyArrayList array = new MyArrayList(10);
        array.insert(1, 0);
        array.insert(2, 1);
        array.remove(1);
        array.outPut();
    }
}
