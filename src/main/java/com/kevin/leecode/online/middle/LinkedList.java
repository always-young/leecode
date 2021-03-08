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

    //旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ||k<=0) return head;
        ListNode p = head;
        int i=1;
        while(p.next!=null) {
            p = p.next;
            i++;
        }
        p.next = head;
        p = head;
        int count = i-k%i;
        while(count>0) {
            p = p.next;
            count--;
        }
        head = p;
        while(i>1) {
            head = head.next;
            i--;
        }
        head.next = null;
        return p;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p = head,prev = h;
        while (p != null&&p.next!=null) {
            ListNode q = p.next;
            if(p.val!=q.val) {
                 prev = p;
                 p = p.next;
            }else{
                while(p.next!=null&&p.val == p.next.val) {
                    p = p.next;
                }
                prev.next = p.next;
                p = p.next;
            }
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        head.next = h1;h1.next = h2;h2.next = h3;
        h3.next = h4;
        new LinkedList().deleteDuplicates(head);
        System.out.println();
    }
}
