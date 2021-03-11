package com.kevin.leecode.godzuo.binarytree;

/**
 * @author kevin lau
 */
public class GetBstMaxSize {

    public int getBstMaxSize(Node node) {
        return getNodeInfo(node).maxSize;
    }

    private Info getNodeInfo(Node node) {
        if (node == null) {
            return null;
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);

        int min = node.val;
        int max = node.val;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        int maxSize = 0;
        if (left != null) {
            maxSize = left.maxSize;
        }
        if (right != null) {
            maxSize = Math.max(maxSize, right.maxSize);
        }
        boolean isBst = false;
        //左子树
        if ((left == null || left.isBst) &&
                        (right == null || right.isBst)
                        && (left == null || left.max < node.val)
                        && (right == null || right.min > node.val)

        ) {
            maxSize = (left == null ? 0 : left.maxSize) + (right == null ? 0 : right.maxSize) + 1;
            isBst = true;
        }
        return new Info(isBst, maxSize, min, max);

    }

    public static class Info {

        public boolean isBst;

        public int maxSize;

        public int min;

        public int max;

        public Info(boolean is, int size, int mi, int ma) {
            isBst = is;
            maxSize = size;
            min = mi;
            max = ma;
        }

    }
}
