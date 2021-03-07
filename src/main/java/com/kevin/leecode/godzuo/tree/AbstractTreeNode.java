package com.kevin.leecode.godzuo.tree;

/**
 * @author kevin lau
 */
public abstract class AbstractTreeNode implements TreeNode{

    private int pass;

    private int end;

    public AbstractTreeNode(){
        pass = 0;
        end = 0;
    }

    @Override
    public void addPass() {
        pass++;
    }

    @Override
    public void reducePass() {
        pass--;
    }

    @Override
    public void addEnd() {
        end++;
    }

    @Override
    public void reduceEnd() {
        end--;
    }

    @Override
    public int getPass(){
        return pass;
    }

    @Override
    public int getEnd(){
        return end;
    }

}
