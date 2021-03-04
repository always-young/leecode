package com.kevin.leecode.godzuo.interview;

import java.util.Arrays;

/**
 * 给定arr 比如 3，1，2 可以生成元祖 3,3 3,1 3,2 1,3 1,1 1,2 等
 * 首先按照第一位排序 然后按照第二位排序
 * 求第k小的数组
 *
 * @author Kevin Liu
 */
public class ArrayToTuple {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 2};
        System.out.println(Arrays.toString(getNumForK(arr, 6)));
    }

    //时间复杂度主要用于排序上了 O(N*logN)
    public static int[] getNumForK(int[] arr, int k) {
        if (arr == null || k < 0 || arr.length * arr.length < k) {
            return null;
        }
        //第一位数 其实就是找第k大的数
        int firstNum = (k - 1) / arr.length;
        Arrays.sort(arr);
        //比第一个数小的数个数
        int lessFirstNum = 0;
        //等于第一个数的个数
        int firstNumSize = 0;
        for (int i = 0; i < arr.length && arr[i] <= arr[firstNum]; i++) {
            if (arr[i] < arr[firstNum]) {
                lessFirstNum++;
            } else {
                firstNumSize++;
            }
        }
        int rest = k - (lessFirstNum * arr.length);

        return new int[]{arr[firstNum], arr[(rest-1)/firstNumSize]};
    }

    //时间复杂度0(N)的解法 不需要排序 只需要找出第k大的数字就行了
    //需要用到bfprt算法：从一个无序的数组中选出第K大或者第K小的数
    public static int[] getNumForK2(int[] arr, int k) {
        return null;
    }


}
