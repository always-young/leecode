package com.kevin.leecode.online.middle;

/**
 * @author kevin lau
 */
public class MyLinkedList {

    private int size;


    private LNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(size==0||index<0||index>=size) {
            return -1;
        }
        LNode p = head;
        for (int i = 0; i < index; i++) {
             p = p.next;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LNode cur = new LNode(val);
        if(head == null) {
            head = cur;
        }else {
            cur.next = head;
            head = cur;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LNode cur = new LNode(val);
        if(head == null) {
            head = cur;
        }
        LNode p = head;
        while(p.next!=null) {
            p = p.next;
        }
        p.next = cur;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size) {
            return;
        }
        if(index<=0) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }
        LNode cur = new LNode(val);
        LNode p = head,q = null;
        for (int i = 0; i < index; i++) {
            q=p;
            p = p.next;
        }
        cur.next = q.next;
        q.next = cur;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || index >= size || index < 0) {
            return;
        }
        LNode p = head, q = null;
        for (int i = 0; i < index; i++) {
            q=p;
            p = p.next;
        }
        if(q == null) {
            head = p.next;
        }else{

        }
    }

    public static void main(String[] args) {
        final MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
        System.out.println("123");
    }
}

class LNode {
    public int val;
    public LNode next;

    public LNode(int val) {
        this.val = val;
    }
}
