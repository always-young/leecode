package com.kevin.leecode.online.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin lau
 */
public class CopyLinkList {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> maps = new HashMap<>();
        Node index = head;
        while (index != null) {
            if (maps.get(index) == null) {
                maps.put(index, new Node(index.val));
            }
            if (index.random != null && maps.get(index.random) == null) {
                maps.put(index.random, new Node(index.random.val));
            }
            index = index.next;
        }
        Node result = new Node(-1), q = result;
        while (head != null) {
            q.next = maps.get(head);
            q.next.random = head.random == null ? null : maps.get(head.random);
            q = q.next;
            head = head.next;
        }
        return result.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}