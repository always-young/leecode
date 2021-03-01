package com.kevin.leecode;

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
        System.out.println(Arrays.toString(getNumForK(arr, 14)));
    }

    public static int[] getNumForK(int[] arr, int k) {
        if (arr == null || k < 0 || arr.length * arr.length < k) {
            return null;
        }
        //第一位数
        int num = (k - 1) / arr.length;
        Arrays.sort(arr);
        int lessFirstNum = 0;
        int firstNum = 0;
        for (int i = 0; i < arr.length && arr[i] <= firstNum; i++) {
            if (arr[i] < firstNum) {
                lessFirstNum++;
            } else {
                firstNum++;
            }
        }
        int rest = k - (lessFirstNum * arr.length);
        rest = rest - firstNum * lessFirstNum;
        return new int[]{arr[num], 0};
    }
}
