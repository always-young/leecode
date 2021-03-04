package com.kevin.leecode.godzuo.sort;

/**
 * @author Kevin Liu
 */
public interface Sort {

    /**
     * 将一个数组arr从start到end排序
     *
     * @param arr arr
     * @param start start
     * @param end end
     */
    void sort(int []arr,int start,int end);


    /**
     * arr排序
     * @param arr arr
     */
    default void sort(int []arr) {
        sort(arr,0,arr.length-1);
    }

     default void swap(int []arr,int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }



}
