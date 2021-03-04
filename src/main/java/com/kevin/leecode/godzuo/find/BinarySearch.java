package com.kevin.leecode.godzuo.find;

/**
 * 二分查找相关
 *
 * @author Kevin Liu
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 5, 6, 2, 3, 4, 567, 12, 11, 45, 31, -1, 2, 3123, 3, 19};
        //测试二分查找
//        Sort sort = new SelectSort();
//        sort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        //测试局部最小值

        System.out.println(localMinimum(arr));
    }

    //普通二分查找
    public static int binarySearch(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0, R = arr.length - 1;
        int mid = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return mid;
    }

    //二分查找匹配最左边的
    public static int binarySearchLeft(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0, R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == value) {
                index = mid;
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    //找值相等的最右侧的值
    public static int binarySearchRight(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0, R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == value) {
                index = mid;
                L = mid + 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    //局部最小值
    public static int localMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int L = 1, R = arr.length - 2;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return -1;
    }
}
