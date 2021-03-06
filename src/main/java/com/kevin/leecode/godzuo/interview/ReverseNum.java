package com.kevin.leecode.godzuo.interview;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 逆序对 使用归并排序
 * @author kevin lau
 */
public class ReverseNum {

    public int reverseNum(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        return reverseNum(arr, start, mid) + reverseNum(arr, mid + 1, end) + merge(arr, start, mid, end);

    }

    private int merge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int size = 0;
        int i = 0;
        int left = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                help[i++] = arr[left++];
                size += end - right +1;
            } else {
                help[i++] = arr[right++];
            }
        }
        while (left <= mid) {
            help[i++] = arr[left++];
        }
        while (right <= end) {
            help[i++] = arr[right++];
        }
        if (help.length >= 0) {
            System.arraycopy(help, 0, arr, start, help.length);
        }
        return size;
    }
}
