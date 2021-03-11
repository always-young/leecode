package com.kevin.leecode.online.simple.tree;

import java.util.*;

/**
 * @author kevin lau
 */
public class LeeBinaryTree {

    public List<String> binaryTreePaths(TreeNode root) {
        return getNodeInfo(root).strs;
    }

    private Info getNodeInfo(TreeNode root) {
        if (root == null) {
            return new Info(null);
        }
        Info left = getNodeInfo(root.left);
        Info right = getNodeInfo(root.right);
        List<String> list = new ArrayList<>();
        if(left.strs!=null) {
            for (String str : left.strs) {
                list.add(root.val + "->" + str);
            }
        }
        if(right.strs!=null) {
            for (String str : right.strs) {
                list.add(root.val + "->" + str);
            }
        }
        if(left.strs == null && right.strs ==null) {
            list.add(root.val + "");
        }
        return new Info(list);
    }

    //左叶子和
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        if(root.left!=null&&root.left.left == null&&root.left.right==null) {
            res = root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

    //二叉树中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if(root!=null) {
                stack.add(root);
                root = root.left;
            }else{
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        TreeNode curEnd = root,nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if(poll.left!=null) {
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if(poll.right!=null) {
                queue.add(poll.right);
                nextEnd = poll.right;
            }
            level.add(poll.val);
            if(poll == curEnd) {
                result.add(level);
                curEnd = nextEnd;
                level = new ArrayList<>();
            }
        }
        //矩形打印
        for (int i = 0; i < result.size(); i++) {
            if(i%2!=0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    //前序 后序构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        //preOrder[0]是根节点 现在找到左右两边的前序和中序就可以递归了
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        //获取左树的前序
        int[] preLeft = new int[index];
        System.arraycopy(preorder, 1, preLeft, 0, index);
        //获取左树的中序
        int[] inLeft = new int[index];
        System.arraycopy(inorder, 0, inLeft, 0, index);

        //获取右树的长度
        int right = inorder.length - index -1;
        //获取右树的前序
        int [] preRight = new int[right];
        System.arraycopy(preorder,index +1 ,preRight,0,right);
        //获取右树的中序
        int [] inRight = new int[right];
        System.arraycopy(inorder,index+1,inRight,0,right);
        //递归
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        return root;

    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length != inorder.length || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if (postorder.length == 1) {
            return root;
        }
        //preOrder[0]是根节点 现在找到左右两边的前序和中序就可以递归了
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        //获取左树的后序
        int[] preLeft = new int[index];
        System.arraycopy(postorder, 0, preLeft, 0, index);
        //获取左树的中序
        int[] inLeft = new int[index];
        System.arraycopy(inorder, 0, inLeft, 0, index);

        //获取右树的长度
        int right = inorder.length - index -1;
        //获取右树的前序
        int [] preRight = new int[right];
        System.arraycopy(postorder,index ,preRight,0,right);
        //获取右树的中序
        int [] inRight = new int[right];
        System.arraycopy(inorder,index+1,inRight,0,right);
        //递归
        root.left = buildTree(inLeft,preLeft);
        root.right = buildTree(inRight,preRight);
        return root;
    }

    //有序数组转二叉搜素树
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int index = nums.length / 2;
        TreeNode root = new TreeNode(nums[index]);
        int [] left  = new int[index];
        System.arraycopy(nums,0,left,0,index);
        int [] right  = new int[nums.length - index -1];
        System.arraycopy(nums,index + 1,right,0,nums.length - index -1);
        root.left  = sortedArrayToBST(left);
        root.right  = sortedArrayToBST(right);
        return root;
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        final int i = new LeeBinaryTree().sumOfLeftLeaves(n1);
        System.out.println(i);
    }

    public static class Info {

        public List<String> strs ;

        public Info(List<String> strs) {
            this.strs = strs;
        }

    }
}
