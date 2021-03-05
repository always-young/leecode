package com.kevin.leecode.godzuo.linkedlist;

/**
 * 自己实现的栈
 *
 * @author Kevin Liu
 */
public class MyStack {

    private DoubleLinkedList doubleLinkedList;

    public MyStack() {
        this.doubleLinkedList = new DoubleLinkedList();
    }

    public MyStack(int size) {
        this.doubleLinkedList = new DoubleLinkedList(size);
    }

    public void push(int val) {
        doubleLinkedList.addToHead(val);
    }

    public int pop(){
       return doubleLinkedList.popFromHead();
    }
    public int peek(){
        return doubleLinkedList.peekHead();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
