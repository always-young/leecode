package com.kevin.leecode.online.simple;

import com.kevin.leecode.godzuo.linkedlist.Node;

import java.util.HashSet;

/**
 * leecode链表相关题目
 *
 * @author kevin lau
 */
public class LinkedList {

    /**
     * 判断链表回文 时间O(n) 空间O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;

        ListNode p = head,q = head;
        while(q.next!=null&&q.next.next!=null) {
            q= q.next.next;
            p = p.next;
        }
        //奇数个p中点位置 偶数个p为偶数前一个位置
        ListNode n3 = p;
        ListNode pre = n3,next;
        p = p.next;
        while(p!=null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        while(head!=n3.next&&pre!=n3) {
            if(head.val!=pre.val) return false;
            head = head.next;
            pre = pre.next;
        }
        return true;

    }

    //删除链表
    public void deleteNode(ListNode node) {
        final ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    //二进制的链表转为十进制
    public int getDecimalValue(ListNode head) {
        if(head ==null) return 0;
        StringBuilder builder = new StringBuilder();
        ListNode p = head;
        while(p!=null) {
            builder.append(p.val);
            p = p.next;
        }
        return Integer.parseInt(builder.reverse().toString(),2);
    }

    /**
     * 反转打印
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode pre = null,next = null;
        int i=0;
        while(head != null) {
            next =  head.next;
            head.next = pre;
            pre = head;
            head = next;
            i++;
        }
        int [] res = new int[i];
        i = 0;
        while(pre!=null) {
            res[i++] = pre.val;
            pre = pre.next;
        }

        return res;
    }

    /**
     * 获取倒数第K个
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode fast = head;
        while(fast!=null&&k>0) {
            fast = fast.next;
            k--;
        }
        while(fast!=null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    /**
     * 链表香蕉
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = headA,q = headB;
        while(p!=q) {
            p = p.next;
            q = q.next;
            if(p == null&&q!=null) p = headB;
            if(q == null&&p!=null) q = headA;
        }
        return p;
    }

    /**
     * 删除重复结点
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p = head,q,z = p;
        HashSet<Integer> set = new HashSet<>();
        set.add(p.val);
        q=p;
        while (q.next != null ) {
            if(!set.contains(q.next.val)) {
                set.add(q.next.val);
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}
