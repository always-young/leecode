package com.kevin.leecode.godzuo.linkedlist;

/**
 * @author Kevin Liu
 */
public class MyQueue {

    private DoubleLinkedList doubleLinkedList;

    public MyQueue(){
        doubleLinkedList = new DoubleLinkedList();
    }

    public MyQueue(int size){
        doubleLinkedList = new DoubleLinkedList(size);
    }

    public void add(int value) {
        doubleLinkedList.addToHead(value);
    }

    public int poll() {
        return doubleLinkedList.popFromTail();
    }

    public int peek() {
        return doubleLinkedList.peekTail();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
