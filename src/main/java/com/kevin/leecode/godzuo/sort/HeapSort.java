package com.kevin.leecode.godzuo.sort;

/**
 * @author kevin lau
 */
public class HeapSort implements Sort{

    private final Heap heap;

    public HeapSort(){
        heap = new Heap();
    }

    @Override
    public void sort(int[] arr, int start, int end) {
        for (int i = start; i <=end ; i++) {
            heap.push(arr[i]);
        }
        int []help = new int[end-start+1];
        int i=0;
        while(!heap.isEmpty()) {
            help[help.length-1-i++] = heap.pop();
        }
        System.arraycopy(help,0,arr,start,help.length);
    }
}
