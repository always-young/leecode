package com.kevin.leecode.godzuo.tree;


/**
 * @author kevin lau
 */
public class ArrayTreeNode extends AbstractTreeNode{

    private final TreeNode[] nexts;

    public ArrayTreeNode() {
        super();
        nexts = new TreeNode[26];
    }

    @Override
    public void clearNext(int index) {
        nexts[index] = null;
    }

    @Override
    public TreeNode setNext(int index) {
        TreeNode node = new ArrayTreeNode();
        nexts[index] = node;
        return node;
    }

    @Override
    public TreeNode getNext(int index) {
        return nexts[index];
    }

}
