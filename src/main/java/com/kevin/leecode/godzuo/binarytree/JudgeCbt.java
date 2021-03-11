package com.kevin.leecode.godzuo.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 * 1.按层级遍历  如果有右节点无子节点 直接返回  如果是儿女不双全 那么后面的都要是叶节点
 *
 * @author kevin lau
 */
public class JudgeCbt {


    public boolean iscBT(Node node) {
        if (node == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.right != null && poll.left == null) {
                return false;
            }
            if (isLeaf && (node.left != null || node.right != null)) {
                return false;
            }
            if (poll.left != null && poll.right == null) {
                isLeaf = true;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }

        }
        return true;
    }

    public boolean iscBT2(Node node) {
        return getNodeInfo(node).isCbt;
    }

    public Info getNodeInfo(Node node) {
        if (node == null) {
            return new Info(0, true, true);
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isFbt = left.isFbt && right.isFbt && left.height == right.height;
        boolean isCbt = false;
        if (isFbt) {
            isCbt = true;
        } else {
            if (right.isFbt && left.isCbt && (left.height - right.height == 1)) {
                isCbt = true;
            }
            if (left.isFbt && right.isFbt && (left.height - right.height == 1)) {
                isCbt = true;
            }
            if (left.isFbt && right.isCbt && (left.height == right.height)) {
                isCbt = true;
            }
        }
        return new Info(height, isFbt, isCbt);
    }

    public static class Info {
        public int height;

        public boolean isFbt;

        public boolean isCbt;

        public Info(int height, boolean isFbt, boolean isCbt) {
            this.height = height;
            this.isFbt = isFbt;
            this.isCbt = isCbt;
        }
    }

}
