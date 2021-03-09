package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

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


    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode sH = null, sE = null, mH = null, mE = null;
        while (head != null) {
            if (head.val < x) {
                if (sH == null) {
                    sH = head;
                    sE = head;
                } else {
                    sE.next = head;
                    sE = head;
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
            sE.next = mH;
        }
        if(mE!=null) mE.next = null;
        return sH == null ? mH : sH;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left>right) {
            return null;
        }
        ListNode h  = new ListNode(-1);
        h.next = head;
        //记录修改前的位置
        ListNode prev = h;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode p = null,next = null,q = prev.next;
        for(int i = 0;i<=right - left;i++ ) {
            next = q.next;
            q.next = p;
            p = q;
            q = next;
        }
        prev.next.next = next;
        prev.next = p;
        return h.next;
    }

    //获取链表环的第一个节点
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next ==null||head.next.next == null) {
            return null;
        }

        ListNode slow = head.next,fast = head.next.next;
        while (slow != fast) {
            if(fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null||head.next.next == null) {
            return ;
        }
        ListNode slow = head.next,fast = head.next.next;
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时slow就是中点 将slow后面的开始反转
        ListNode p = slow.next;
        ListNode q = null,next;
        while(p!=null) {
            next = p.next;
            p.next = q;
            q = p;
            p = next;
        }
        int i=0;
        ListNode z = head;
        ListNode k = new ListNode(-1),x = k;
        slow.next = null;
        while (z != null && q!=null) {
            if (i % 2 == 0) {
                x.next = z;
                z = z.next;
            } else {
                x.next = q;
                q = q.next;
            }
            x = x.next;
            i++;
        }
        while(z!=null) {
            x.next = z;
            z=z.next;
            x = x.next;
        }
        while(q!=null) {
            x.next = q;
            q = q.next;
            x = x.next;
        }
        head = k.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1),pre;
        dummy.next = head;
        while (head != null&&head.next!=null) {
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while(pre.next.val < head.next.val) {
                pre =pre.next;
            }
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;

    }


    public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next ==null) {
           return head;
       }
       ListNode odd = null,even = null,prev  = null,last = null;
       int i=1;
        while (head != null) {
            if (i % 2 != 0) {
               if(odd==null) {
                    odd = head;
                    prev = head;
               }else{
                   odd.next = head;
                   odd =head;
               }
            } else {
                if(even == null) {
                    even = head;
                    last = head;
                }else{
                    even.next = head;
                    even = head;
                }
            }
            i++;
            head = head.next;
        }
        if(even!=null) {
            even.next = null;
        }
        odd.next = last;
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        ListNode h6 = new ListNode(7);
        head.next = h1;h1.next = h2;h2.next = h3;
        h3.next = h4;h4.next = h5;h5.next = h6;
        new LinkedList().reorderList(head);
        System.out.println();
    }
}
