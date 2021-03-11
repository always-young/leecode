package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

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
                    ListNode val = new ListNode(head.val);
                    val.next = sH;
                    sH = val;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mE = head;
                } else {
                    ListNode val = new ListNode(head.val);
                    val.next = mH;
                    mH = val;
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

    //旋转给定值的链表
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

    //重排链表
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

    //
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        while(l1!=null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int scale = 0;
        int s,v;
        while(!s1.empty()&&!s2.empty()) {
            s = s1.pop() + s2.pop() + scale;
            v = s % 10;
            scale = s/10;
            sum.add(v);
        }
        while(!s1.empty()) {
            s = s1.pop()+scale;
            v = s %10;
            scale = s/10;
            sum.add(v);
        }
        while(!s2.empty()) {
            s = s2.pop()+scale;
            v = s %10;
            scale = s/10;
            sum.add(v);
        }
        if(s1.empty()&&s2.empty()&&scale!=0) {
            sum.add(scale);
        }
        ListNode h = new ListNode(-1),z=h;
        while(!sum.isEmpty()) {
            h.next = new ListNode(sum.pop());
            h = h.next;
        }
        return z.next;
    }

    //分割链表
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(k<=0) {
            return new ListNode[0];
        }
        ListNode []node = new ListNode[k];
        ListNode s = root;
        int size = 0;
        while(s!=null) {
            size++;
            s = s.next;
        }
        s = root;
        int i=0;
        if (size <= k) {
           while(s!=null) {
               node[i++] = new ListNode(s.val);
               s = s.next;
           }
        }else{
            int base = size / k;
            int another =size % k;
            while(s!=null) {
                ListNode prev = null;
                for(int z = 0;z<base;z++) {
                    if(node[i] == null) {
                        node[i] = new ListNode(s.val);
                        prev = node[i];
                    }else{
                        ListNode listNode = new ListNode(s.val);
                        prev.next = listNode;
                        prev = prev.next;
                    }
                    s = s.next;
                }
                if(another>0) {
                    prev.next = new ListNode(s.val);
                    another--;
                    s = s.next;
                }
                i++;
            }
        }
        return node;

    }

    //链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null&&l2==null) return null;
        if(l1==null) return l2;
        if (l2==null) return l1;

        ListNode result = new ListNode(-1),q = result;
        int scale = 0;
        int sum;
        while(l1!=null&&l2!=null) {
            sum = l1.val+l2.val+scale;
            q.next = new ListNode(sum % 10);
            q = q.next;
            scale = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null) {
            sum = l1.val + scale;
            q.next = new ListNode(sum % 10);
            q = q.next;
            scale = sum / 10;
            l1 = l1.next;
        }
        while (l2!=null) {
            sum = l2.val + scale;
            q.next = new ListNode(sum % 10);
            q = q.next;
            scale = sum / 10;
            l2 = l2.next;
        }
        if(scale!=0)  q.next = new ListNode(scale);
        return result.next;
    }

    //交换正数第K个和倒数第K个
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null ||head.next == null|| k <=0) return head;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h,z = head;
        for (int i = 0; i < k-1; i++) {
            pre = z;
            z= z.next;
            if(z == null) {
                return null;
            }
        }

        ListNode start = head,p = h,end = z;
        while(end.next!=null) {
            p = start;
            start = start.next;
            end = end.next;
        }
        //start和z为要交换的结点 prev和p为两个交换的前结点
        //不相邻
        if(z.next==start) {
            ListNode next = start.next;
            pre.next = start;
            start.next = z;
            z.next = next;
            return h.next;
        }
        if(start.next == z) {
            ListNode next = z.next;
            p.next = z;
            z.next = start;
            start.next = next;
            return h.next;
        }
        ListNode next = start.next;
        pre.next = start;
        start.next = z.next;
        p.next = z;
        z.next = next;
        return h.next;
    }

    //删除第一个链表 拼接上第二个链表
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null || a>b) return null;
        ListNode pre = new ListNode(-1),p = pre;
        pre.next = list1;
        ListNode index = list1;
        //p表示要移出的前序结点 index表示被删除的结点
        for (int i = 0; i < a; i++) {
            p = index;
            index = index.next;
        }
        for (int i = 0; i < b - a; i++) {
            index = index.next;
        }
        p.next = list2;
        p = list2;
        while(p.next!=null) {
            p = p.next;
        }
        p.next = index.next;
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(100);
        ListNode h1 = new ListNode(90);
        head.next = h1;
        System.out.println(new LinkedList().swapNodes(head, 2));
        System.out.println();
    }
}
