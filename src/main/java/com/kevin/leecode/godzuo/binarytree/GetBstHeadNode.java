package com.kevin.leecode.godzuo.binarytree;

/**
 * @author kevin lau
 */
public class GetBstHeadNode {


    public Node getHead(Node node) {
        return getNodeInfo(node).head;
    }

    private Info getNodeInfo(Node node) {
        if (node == null) {
            return null;
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);
        int min = node.val;
        int max = node.val;
        int maxSize = 0;
        Node head = null;
        if (left != null) {
            min = Math.min(left.min, min);
            max = Math.max(left.max, max);
            maxSize = left.maxSize;
            head = left.head;
        }
        if (right != null) {
            min = Math.min(right.min, min);
            max = Math.max(right.max, max);
            if (right.maxSize > maxSize) {
                head = right.head;
                maxSize = right.maxSize;
            }
        }

        if (
                (left == null || left.head != null) &&
                        (right == null || right.head != null) &&
                        (left == null || left.max < node.val) &&
                        (right == null || right.min > node.val)
        ) {
            maxSize = (left == null ? 0 : left.maxSize) + (right == null ? 0 : right.maxSize) + 1;
            return new Info(node, maxSize, min, max);
        }
        return new Info(head, maxSize, min, max);

    }

    public static class Info {

        public Node head;

        public int maxSize;

        public int min;

        public int max;

        public Info(Node head, int maxSize, int min, int max) {
            this.head = head;
            this.maxSize = maxSize;
            this.min = min;
            this.max = max;
        }
    }
}
