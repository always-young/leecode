package com.kevin.leecode.sort;

import java.util.Arrays;

/**
 * @author Kevin Liu
 */
public class SortTest {

    public static void main(String[] args) {
        int []arr = new int[] {1,4,5,6,2,3,4,567,12,12312,45,31,-1,2,3123,3,-19};
        //冒泡排序
        //Sort sort = new BubbleSort();
        //插入排序
        //Sort sort  = new InsertSort();
        //选择排序
        Sort sort = new SelectSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
