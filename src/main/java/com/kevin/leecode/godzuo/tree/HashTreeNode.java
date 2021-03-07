package com.kevin.leecode.godzuo.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin lau
 */
public class HashTreeNode extends AbstractTreeNode {

    private Map<Integer, TreeNode> nexts;

    public HashTreeNode() {
        super();
        nexts = new HashMap<>();
    }

    @Override
    public void clearNext(int index) {
        nexts.remove(index);
    }

    @Override
    public TreeNode setNext(int index) {
        TreeNode node = new HashTreeNode();
        nexts.put(index, node);
        return node;
    }

    @Override
    public TreeNode getNext(int index) {
        return nexts.get(index);
    }
}
