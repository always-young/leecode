package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.tree.TreeNode;

/**
 * 二叉树转链表
 *
 * @author kevin lau
 */
public class TransferLink {

    public void flatten(TreeNode root) {
        root = getNodeInfo(root).head;
    }

    private Info getNodeInfo(TreeNode node) {
        if(node == null) {
            return new Info(null,null);
        }
        Info left = getNodeInfo(node.left);
        Info right = getNodeInfo(node.right);
        TreeNode tail = node;
        if(left.head!=null) {
            node.right = left.head;
            if(right.head!=null) {
                left.tail.right = right.head;
                tail = right.tail;
            }else{
                tail = left.tail;
            }
        }else{
            if(right.head!=null) {
                node.right = right.head;
                tail = right.tail;
            }else{
                tail = node;
            }
        }
        node.left = null;
        return new Info(node,tail);
    }

    public static class Info {
        public TreeNode head;

        public TreeNode tail;

        public Info(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
