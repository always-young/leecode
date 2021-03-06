package com.kevin.leecode.godzuo.interview;

import java.util.Arrays;

/**
 * partition
 *
 * @author kevin lau
 */
public class Partition {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 3, 421, 12, 3, 4, 6, 7, 324, 8, 34, 231, 8, 86, 2134, 8};
        final Partition partition = new Partition();
        partition.partition2(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 只区分大于小于
     *
     * @param arr
     * @param num
     */
    public void partition(int[] arr, int num) {
        int L = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, ++L, i);
            }
        }

    }

    /**
     * 区分大于等于小于 三种情况
     *
     * @param arr
     * @param num
     */
    public void partition2(int[] arr, int num) {
        int L = -1, R = arr.length;
        for (int i = 0; i < R; i++) {
            if (arr[i] < num) {
                swap(arr, ++L, i);
            } else if (arr[i] > num) {
                swap(arr, i--, --R);
            }
        }
    }

    public int[] partition2(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int less = L - 1, index = L, more = R;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr,R,more);
        return new int[]{less + 1, more};

    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
