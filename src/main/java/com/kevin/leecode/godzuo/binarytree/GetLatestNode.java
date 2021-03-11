package com.kevin.leecode.godzuo.binarytree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定头结点和a b两个结点 找a和b的最近的公共父节点
 *
 * @author kevin lau
 */
public class GetLatestNode {

    public Node getParentNode(Node head, Node a, Node b) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> maps = new HashMap<>();
        HashSet<Node> sets = new HashSet<>();
        maps.put(head, null);
        fixParentMap(head, maps);
        Node cur = a;
        sets.add(cur);
        while (maps.get(cur) != null) {
            cur = maps.get(cur);
            sets.add(cur);
        }
        cur = b;
        while (!sets.contains(cur)) {
            cur = maps.get(cur);
        }
        return null;
    }

    private void fixParentMap(Node head, HashMap<Node, Node> maps) {
        if (head.left != null) {
            maps.put(head.left, head);
            fixParentMap(head.left, maps);
        }
        if (head.right != null) {
            maps.put(head.right, head);
            fixParentMap(head.right, maps);
        }
    }

    public Node getParentNode2(Node head, Node a, Node b) {
        return getNodeInfo(head, a, b).ans;
    }

    private Info getNodeInfo(Node node, Node a, Node b) {
        if (node == null) {
            return new Info(false, false, null);
        }
        Info left = getNodeInfo(node.left, a, b);
        Info right = getNodeInfo(node.right, a, b);
        boolean hasA = left.isHasA || right.isHasA || a == node;
        boolean hasB = left.isHasB || right.isHasB || b == node;
        Node ans = null;
        if (hasA && hasB) {
            if (left.ans != null) {
                ans = left.ans;
            } else if (right.ans != null) {
                ans = right.ans;
            } else {
                ans = node;
            }
        }
        return new Info(hasA, hasB, ans);

    }

    public static class Info {

        public boolean isHasA;

        public boolean isHasB;

        public Node ans;

        public Info(boolean isHasA, boolean isHasB, Node ans) {
            this.isHasA = isHasA;
            this.isHasB = isHasB;
            this.ans = ans;
        }
    }

}
