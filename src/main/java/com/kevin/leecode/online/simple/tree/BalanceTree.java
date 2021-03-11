package com.kevin.leecode.online.simple.tree;

/**
 * @author kevin lau
 */
public class BalanceTree {

    public boolean isBalanced(TreeNode root) {
        return isBst(root).isBst;
    }

    private Info isBst(TreeNode node) {
        if(node == null) {
            return new Info(0,true);
        }
        Info left = isBst(node.left);
        Info right = isBst(node.right);
        int height = Math.max(left.height, right.height) + 1;
        if(!left.isBst||!right.isBst||Math.abs(left.height - right.height) > 1) {
           return new Info(height,false);
        }
        return new Info(height,true);
    }


}

class Info{
    public int height;

    public boolean isBst;

    public Info(int height,boolean isBst) {
        this.height = height;
        this.isBst = isBst;
    }
}
