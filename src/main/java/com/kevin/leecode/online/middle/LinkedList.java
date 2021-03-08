package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.ListNode;

/**
 * @author kevin lau
 */
public class LinkedList {

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode de = new ListNode(0);
        de.next = head;
        ListNode pre = de;
        ListNode  cur = head;
        while (cur != null && cur.next != null) {
            //使用临时结点存储当前第一、二、三个结点
            ListNode first = cur;
            ListNode second = cur.next;
            ListNode third = cur.next.next;
            //交换
            pre.next = second;
            second.next = first;
            first.next = third;
            //cur后移两位，pre后移两位
            pre = first;
            cur = third;

        }
        return de.next;
    }
}
