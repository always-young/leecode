package com.kevin.leecode.godzuo.binarytree;

/**
 * @author kevin lau
 */
public class SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if(node == null) {
            return null;
        }
        //因为中序遍历 如果node右结点不为空 那么后继结点一定是右子树的最左结点
        if(node.right!=null) {
             node = node.right;
             if(node.left!=null) {
                 node = node.left;
             }
             return node;
        }else{
            Node parent = node.parent;
            while(parent!=null&&parent.right == node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

}
