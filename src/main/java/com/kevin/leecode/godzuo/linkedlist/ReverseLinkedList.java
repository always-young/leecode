package com.kevin.leecode.godzuo.linkedlist;

/**
 * 反转单向链表以及双向链表
 *
 * @author Kevin Liu
 */
public class ReverseLinkedList {


    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public static Node reversLinkedList(Node head) {
        Node pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向向链表
     * @param head
     * @return
     */
    public static DoubleNode reversDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
