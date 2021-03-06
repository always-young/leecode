package com.kevin.leecode.godzuo.sort;

/**
 * 快速排序
 *
 * @author kevin lau
 */
public class QuickSort implements Sort{

    @Override
    public void sort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        swap(arr, start + (int) (Math.random() * (end - start + 1)), end);
        int []a = process(arr,start,end);
        sort(arr,start,a[0]-1);
        sort(arr,a[1] +1,end);
    }

    private int[] process(int[] arr, int L, int R) {
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
}
