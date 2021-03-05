package com.kevin.leecode.stack;

/**
 * 循环数组实现
 *
 * @author Kevin Liu
 */
public class RingBuffer {

    private final static int DEFAULT_SIZE = 16;

    private int []data;

    private int size;

    private int limit;

    private int head;

    private int tail;

    public RingBuffer() {
        this(DEFAULT_SIZE);
    }

    public RingBuffer(int limit) {
        this.data = new int[limit];
        this.size = 0;
        this.limit = limit;
        this.head = -1;
        this.tail = -1;
    }

    public void checkFull(){
        if(limit == size) {
            throw new RuntimeException("data is full");
        }
    }

    public void add(int val) {
        checkFull();
        head = (head + 1)%limit;
        data[head] = val;
        if(tail == -1) {
            tail = head;
        }
        size++;
    }

    public int poll(){
        if(size==0) {
            throw new RuntimeException("data is null");
        }
        int val = data[tail];
        tail = (tail+1)%limit;
        size--;
        return val;
    }

    public int peek(){
        return data[tail];
    }

    public static void main(String[] args) {
        RingBuffer ringBuffer = new RingBuffer();
        for (int i = 0; i < 16; i++) {
            ringBuffer.add(i);
        }
        System.out.println(ringBuffer.poll());
        System.out.println(ringBuffer.poll());
        ringBuffer.add(300);
        ringBuffer.add(301);
        for (int i = 0; i < 16; i++) {
            System.out.println(ringBuffer.poll());
        }

    }
}
