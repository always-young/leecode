package com.kevin.leecode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author Kevin Liu
 */
public class InsertSort implements Sort{

    /**
     * 0-1 有序
     * 0-2 有序
     * 0-3 有序
     * 所以外层循环从1 - N
     * @param arr arr
     */
    @Override
    public void sort(int[] arr, int start, int end) {
        for (int e = 1; e <= end ; e++) {
            for (int j = e; j > start && arr[j] < arr[j - 1]; j--) {
                swap(arr,j,j-1);
            }
        }
    }
}
