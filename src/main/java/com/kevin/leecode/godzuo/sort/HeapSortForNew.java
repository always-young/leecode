package com.kevin.leecode.godzuo.sort;

import java.util.PriorityQueue;

/**
 * @author kevin lau
 */
public class HeapSortForNew implements Sort {


    @Override
    public void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //将数据添加进堆
//        for (int i = start; i <= end; i++) {
//            heapInsert(arr, i);
//        }
        //也可以使用heapIfy添加数据进入堆
        for(int i=end;i>=start;i--) {
            heapIfy(arr,i,end+1);
        }
        //核心
        int heapSize = end+1;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapIfy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }

    private void heapInsert(int[] arr, int heapSize) {
        int index = heapSize;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void kSort(int []arr,int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int  i = 0;
        for (i = 0; i <= Math.min(k,arr.length-1); i++) {
            heap.add(arr[i]);
        }
        int index = 0;
        for(;i<arr.length;i++) {
            arr[index++] = heap.poll();
            heap.add(arr[i]);
        }
        while(!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }

    }
}
