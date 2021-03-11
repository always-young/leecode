package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.ListNode;

/**
 * @author kevin lau
 */
public class FrontMiddleBackQueue {
    private DoubleNode head;

    private DoubleNode tail;

    private int size;

    public FrontMiddleBackQueue() {
        this.size = 0;
    }

    public void pushFront(int val) {
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

    public void pushMiddle(int val) {
        DoubleNode cur = new DoubleNode(val);
        if(head == null) {
            head = cur;
            tail = cur;
            size++;
            return;
        }
        int mid = size / 2;
        DoubleNode h = head;
        for (int i = 0; i < mid-1; i++) {
            h = h.next;
        }
        cur.next = h.next;
        h.next = cur;
        size++;
    }

    public void pushBack(int val) {
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

    public int popFront() {
        if (head == null) {
            return -1;
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

    public int popMiddle() {
        if(head == null) {
            return -1;
        }
        int mid = size /2;
        if(mid == 0||mid==1) {
            return popFront();
        }
        DoubleNode d = null,p = head;
        for (int i = 0; i < mid-1; i++) {
            d = p;
            p = p.next;
        }
        d.next = p.next;
        p.next = null;
        size--;
        return p.value;
    }

    public int popBack() {
        if (tail == null) {
            return -1;
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

    public static void main(String[] args) {
        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        obj.pushFront(1);
        obj.pushBack(2);
        obj.pushMiddle(3);
        obj.pushMiddle(4);
        System.out.println(obj.popFront());
        System.out.println(obj.popMiddle());
        System.out.println(obj.popMiddle());
    }

}

class DoubleNode {

    public int value;

    public DoubleNode last;

    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

}
