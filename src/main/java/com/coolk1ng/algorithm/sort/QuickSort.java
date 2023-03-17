package com.coolk1ng.algorithm.sort;

/**
 * 快速排序
 *
 * @author coolk1ng
 * @since 2023/3/17 13:44
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,5,4,3,6,9,8,6,8,2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partition = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }
    }

    /**
     * 分治
     */
    public int partition(int[] arr, int startIndex, int endIndex) {
        //基准元素
        int base = arr[startIndex];
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;

        while (leftIndex <= rightIndex) {
            //左指针小于基准元素, leftIndex++, 大于基准元素, 交换, rightIndex --
            if (arr[leftIndex] <= base) {
                leftIndex ++;
            } else {
                swap(arr, leftIndex, rightIndex);
                rightIndex --;
            }
        }
        swap(arr, startIndex, rightIndex); //交换基准元素和指针指向元素
        return rightIndex;
    }

    public void  swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
