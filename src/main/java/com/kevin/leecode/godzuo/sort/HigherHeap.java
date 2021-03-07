package com.kevin.leecode.godzuo.sort;

import java.util.*;

/**
 * 可以更改的自定义堆
 *
 * @author kevin lau
 */
public class HigherHeap<T> {

    private Comparator<T>  comparator;

    private List<T> data;

    private Map<T,Integer> indexMap;

    private int heapSize;

    public HigherHeap(){
        this(Comparator.comparingInt(Object::hashCode));
    }

    public HigherHeap(Comparator<T> comparator){
        data = new LinkedList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T val){
        if(indexMap.put(val,heapSize)==null) {
            data.add(val);
            heapInsert();
            heapSize++;
        }
    }

    public T pop(){
        if(isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        T val = data.get(0);
        int end = heapSize-1;
        swap(0,end);
        indexMap.remove(val);
        data.remove(end);
        heapSize--;
        heapIfy();
        return val;
    }

    private void heapIfy() {
        heapIfy(0);
    }


    private void heapIfy(int index) {
        int left = 2*index + 1;
        while(left < heapSize) {
            int largest = left + 1 < heapSize && comparator.compare(data.get(left + 1), data.get(left)) > 0 ? left + 1 : left;
            largest = comparator.compare(data.get(index), data.get(largest)) > 0 ? index : largest;
            if(largest == index) {
                break;
            }
            swap(largest,index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public void resign(T val) {
        Integer size = indexMap.get(val);
        if(size != null) {
            heapInsert (size);
            heapIfy(size);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    private void heapInsert() {
        heapInsert(heapSize);
    }

    private void heapInsert(int index) {
        while(comparator.compare(data.get(index),data.get((index-1)/2))>0) {
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private void swap(int index, int i) {
        T o1 = data.get(index);
        T o2 = data.get(i);
        data.set(i,o1);
        data.set(index,o2);
        indexMap.put(o1,i);
        indexMap.put(o2,index);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer integer = new Integer(99);
        map.put(integer, 1);
        integer = 129;
        map.put(integer, 2);
        System.out.println(map.get(129));
    }
}
