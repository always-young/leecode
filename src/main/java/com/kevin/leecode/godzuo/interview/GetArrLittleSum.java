package com.kevin.leecode.godzuo.interview;

/**
 * 获取数组小和 归并思想
 *
 * @author kevin lau
 */
public class GetArrLittleSum {


    public static void main(String[] args) {

    }

    public int getArrLittleSum(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        return getArrLittleSum(arr, start, mid) + getArrLittleSum(arr, mid + 1, end) + merge(arr, start, mid, end);

    }

    private int merge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int sum = 0;
        int i = 0;
        int left = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                sum += (end - right + 1) * arr[left];
                help[i++] = arr[left++];
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
        return sum;
    }

}
