package com.kevin.leecode.sort;

/**
 * @author Kevin Liu
 */
public class SelectSort implements Sort{


    /**
     * 选择排序
     * 从0 - N   选最大的
     * 从0 - N-1 选第二大的
     *  所以外层循环从N - 0 内层循环判断最大值
     *
     * @param arr arr arr
     * @param start start start
     * @param end end end
     */
    @Override
    public void sort(int[] arr, int start, int end) {
        int m = start;
        for (int e = end; e > start; e--) {
            m = start;
            for (int i = start + 1; i <= e; i++) {
                if (arr[i] > arr[m]) {
                    m = i;
                }
            }
            swap(arr,m,e);
        }
    }

}
