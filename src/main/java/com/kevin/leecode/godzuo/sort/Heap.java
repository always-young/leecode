package com.kevin.leecode.godzuo.sort;

/**
 * 大根堆
 *
 * @author kevin lau
 */
public class Heap {

    private int []data;

    private int limit;

    private int heapSize = 0;

    public Heap(){
        limit = 160;
        data = new int[limit];
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public void push(int val) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        data[heapSize] = val;
        heapInsert();
        heapSize++;
    }
    public int pop() {
        if(heapSize == 0) {
            throw new RuntimeException("heap is empty");
        }
        int value = data[0];
        swap(data,0,--heapSize);
        heapIfy();
        return value;
    }

    private void heapIfy() {
        int index = 0;
        int left = 1;
        while(left< heapSize) {
            int largest = left + 1 < heapSize && data[left + 1] > data[left] ? left + 1 : left;
            largest = data[index] > data[largest]?index:largest;
            if(largest == index) {
                break;
            }
            swap(data,index,largest);
            index = largest;
            left = 2*index + 1;
        }
    }

    private void heapInsert() {
        int index = heapSize;
        while(data[index]>data[(index-1)/2]) {
            swap(data,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        for (int i = 0; i < 10; i++) {
            heap.push(i);
        }
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }

}
