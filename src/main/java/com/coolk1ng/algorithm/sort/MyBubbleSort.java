package com.coolk1ng.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author coolk1ng
 * @since 2023/3/13 16:05
 */
public class MyBubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    //有交换
                    flag = false;
                }
            }

            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 6, 4, 3, 10, 8, 6, 7};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
