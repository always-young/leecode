package com.kevin.leecode.godzuo.linkedlist;

/**
 * 给定一个值 划分链表
 *
 * @author kevin lau
 */
public class Partition {

    public Node partition(Node head, int val) {
        Node sH = null, sE = null, eH = null, eE = null, mH = null, mE = null;
        while (head != null) {
            if (head.value < val) {
                if (sH == null) {
                    sH = head;
                    sE = head;
                } else {
                    sE.next = head;
                    sE = head;
                }
            } else if (head.value == val) {
                if (eH == null) {
                    eH = head;
                    eE = head;
                } else {
                    eE.next = head;
                    eE = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mE = head;
                } else {
                    mE.next = head;
                    mE = head;
                }
            }
            head = head.next;
        }
        if (sH != null) {
            sE.next = eH == null ? mH : eH;
        }
        if (eH != null) {
            eE.next = mH;
        }
        return sH != null ? sH : eH != null ? eH : mH;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(7);
        Node n4 = new Node(4);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node partition = new Partition().partition(n1, 10);
        System.out.println(partition);
    }
}
