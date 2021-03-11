package com.kevin.leecode.online.simple.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 路径总和问题
 *
 * @author kevin lau
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right ==null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        final List<List<Integer>> lists = new PathSum().pathSum(n1,3);
        System.out.println(lists);
    }

    //路径总和 需要打印路径
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return getNodeInfo(root,targetSum).strs;
    }

    private Info getNodeInfo(TreeNode root, int targetSum) {
        if (root == null) {
            return new Info(null, false);
        }
        Info left = getNodeInfo(root.left, targetSum - root.val);
        Info right = getNodeInfo(root.right, targetSum - root.val);
        boolean hasPath = (root.left == null && root.right == null && root.val == targetSum) || (left.hasPath || right.hasPath);
        List<List<Integer>> list = new ArrayList<>();
        if (left.hasPath && left.strs != null) {
            for (List<Integer> str : left.strs) {
                 str.add(root.val);
                 list.add(str);
            }
        }
        if (right.hasPath && right.strs != null) {
            for (List<Integer> str : right.strs) {
                str.add(root.val);
                list.add(str);
            }
        }
        if (hasPath &&left.strs == null && right.strs == null) {
            List<Integer> s = new ArrayList<>();
            s.add(root.val);
            list.add(s);
        }
        for (List<Integer> integers : list) {
            Collections.reverse(integers);
        }
        return new Info(list, hasPath);
    }

    public static class Info {

        public List<List<Integer>> strs ;

        public boolean hasPath;

        public Info(List<List<Integer>> strs, boolean hasPath) {
            this.strs = strs;
            this.hasPath = hasPath;
        }
    }

}