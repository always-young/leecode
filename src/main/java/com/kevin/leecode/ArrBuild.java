package com.kevin.leecode;

import java.util.Arrays;

/**
 * 给定N 生成一个长度为N数组  保证生成的数据满足一下条件
 * 任意的 i<k<j 满足  arr[i] + arr[j] != 2 arr[k]
 *
 * @author Kevin Liu
 */
public class ArrBuild {

    public static int[] makeArr(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int half = (n + 1) / 2;
        int[] base = makeArr(half);
        int[] arr = new int[n];
        int index = 0;
        for (; index < half; index++) {
            arr[index] = base[index] * 2 - 1;
        }
        for (int i = 0; index < n; index++, i++) {
            arr[index] = base[i] * 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        final int[] ints = makeArr(5);
        System.out.println(Arrays.toString(ints));
    }
}
