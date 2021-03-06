package com.kevin.leecode.godzuo.sort;

/**
 * @author kevin lau
 */
public class MergeSort implements Sort {


    @Override
    public void sort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int left = start, right = mid + 1;
        int i=0;
        while (left <= mid && right <= end) {
            help[i++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while(left<=mid) {
            help[i++] = arr[left++];
        }
        while(right<=end) {
            help[i++] = arr[right++];
        }
        if (help.length >= 0) {
            System.arraycopy(help, 0, arr, start, help.length);
        }
    }
}
