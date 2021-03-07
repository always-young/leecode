package com.kevin.leecode.godzuo.tree;

/**
 * @author kevin lau
 */
public interface TreeNode {

    void addPass();

    void addEnd();

    void reducePass();

    void reduceEnd();

    int getPass();

    int getEnd();

    void clearNext(int index);

    TreeNode setNext(int index);

   TreeNode getNext(int index);


}
