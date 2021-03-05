package com.kevin.leecode.godzuo.linkedlist;

/**
 * 双向链表 提供四个功能 首插入
 *
 * @author Kevin Liu
 */
public class DoubleLinkedList {

    private DoubleNode head;

    private DoubleNode tail;

    private int size;

    private int limit;

    public DoubleLinkedList(){
        this.limit = 2<<4;
        this.size = 0;
    }

    public DoubleLinkedList(int limit) {
        this.limit = limit;
        this.size = 0;
    }

    public void addToHead(int val) {
        if(size == limit) {
            throw new RuntimeException("size is full");
        }
        DoubleNode cur = new DoubleNode(val);
        if (head == null) {
            head = cur;
            tail = head;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
        size ++;
    }

    public int popFromHead() {
        if (head == null) {
            throw new RuntimeException("data is null");
        }
        DoubleNode cur = head;
        head = head.next;
        if (head != null) {
            head.last = null;
        }
        cur.next = null;
        size--;
        return cur.value;
    }

    public int popFromTail() {
        if (tail == null) {
            throw new RuntimeException("data is null");
        }
        DoubleNode cur = tail;
        tail = tail.last;
        if (tail != null) {
            tail.next = null;
        }
        cur.last = null;
        size--;
        return cur.value;
    }

    public int peekHead() {
        checkNode(head);
        return head.value;
    }

    private void checkNode(DoubleNode node) {
        if (node == null) {
            throw new RuntimeException("node is null");
        }
    }

    public int peekTail() {
        checkNode(tail);
        return tail.value;
    }

    public void addToTail(int val) {
        if(size == limit) {
            throw new RuntimeException("size is full");
        }
        DoubleNode cur = new DoubleNode(val);
        if (tail == null) {
            tail = cur;
            head = tail;
        } else {
            tail.next = cur;
            cur.last = tail;
            tail = cur;
        }
        size++;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addToHead(1);
        list.addToTail(13);
        System.out.println(list.popFromHead());
        System.out.println(list.popFromHead());
    }
}
