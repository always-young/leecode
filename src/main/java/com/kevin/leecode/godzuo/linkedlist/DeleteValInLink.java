package com.kevin.leecode.godzuo.linkedlist;

/**
 * 删除链表的等于val的数字
 *
 * @author Kevin Liu
 */
public class DeleteValInLink {

    public static Node deleteValInLink(Node head, int val) {
        while (head != null) {
            if (head.value != val) {
                break;
            }
            head = head.next;
        }
        Node pre = head, cur = head;
        while (cur != null) {
            if (cur.value == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
