package com.kevin.leecode.godzuo.sort;

/**
 * 基数排序
 *
 * @author kevin lau
 */
public class BaseSort implements Sort {


    @Override
    public void sort(int[] arr, int start, int end) {
        baseSort(arr,start,end,getMaxBit(arr,start,end));
    }

    private void baseSort(int[] arr, int start, int end, int maxBit) {
        if(arr == null||arr.length<2) {
            return;
        }
        int []help2 = new int[end - start + 1];
        for (int i = 1; i <= maxBit; i++) {
            int []help = new int[10];
            for(int index = start;index<=end;index++) {
                int val = getValue(arr[index],i);
                help[val]++;
            }
            for (int d = 1; d < help.length; d++) {
                help[d] = help[d] + help[d-1];
            }
            for(int index = end ;index>=start;index--) {
                int val = getValue(arr[index],i);
                help2[help[val]-1] = arr[index];
                help[val]--;
            }
            System.arraycopy(help2,0,arr,start,help2.length);
        }
    }

    private int getValue(int value, int count) {
        return  (value / (int)Math.pow(10, count - 1)) % 10;
    }

    private int getMaxBit(int[] arr, int L, int R) {
        int max = arr[L];
        for (int i = L + 1; i <= R; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max > 0) {
            res++;
            max = max / 10;
        }
        return res;
    }
}
