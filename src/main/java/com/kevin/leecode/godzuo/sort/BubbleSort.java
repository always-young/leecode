package com.kevin.leecode.godzuo.sort;

/**
 * 冒泡排序
 *
 * @author Kevin Liu
 */
public class BubbleSort implements Sort{

    /**
     *  0 - N   冒出最大的
     *  0 - N-1 冒出第二大的
     *  0 - N-2 冒出第三大的
     *  所以外层循环从N.....1
     * @param arr arr
     */
    @Override
    public void sort(int[] arr, int start, int end) {
        for (int e = end; e > start; e--) {
            for (int j = start; j < e; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }
}
