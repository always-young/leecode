package com.kevin.leecode.godzuo.binarytree;

/**
 * 判断是否满二叉树
 *
 * @author kevin lau
 */
public class JudgeFixBinaryTree {

    public boolean isFbt(Node node) {
        final Info nodeInfo = getNodeInfo(node);
        return  2 >> nodeInfo.height == (nodeInfo.count | 1);
    }

    private Info getNodeInfo(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);
        int height = Math.max(left.height, right.height) + 1;
        int count = left.count + right.count +1;
        return new Info(height,count);
    }


    public static class Info {

        public int height;

        public int count;

        public Info(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}
