package com.kevin.leecode.godzuo.binarytree;

import com.kevin.leecode.online.simple.tree.TreeNode;

import java.util.*;

/**
 * @author kevin lau
 */
public class BinaryTree {


    //前序打印
    public void pre(Node node) {
        if(node == null) return;
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    //前序打印非递归
    public void pre2(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.val);
            if(pop.right!=null) stack.add(pop.right);
            if(pop.left!=null) stack.add(pop.left);
        }
    }
    //中序打印
    public void mid(Node node) {
        if(node == null) return;
        mid(node.left);
        System.out.println(node.val);
        mid(node.right);
    }

    //中序打印非递归
    public void mid2(Node node) {
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty()||node!=null) {
            if(node.left!=null) {
                stack.add(node);
                node = node.left;
            }else{
                Node pop = stack.pop();
                System.out.println(pop.val);
                node = node.right;
            }
        }
    }

    /**
     * 后续遍历
     * @param node
     */
    public void pos(Node node) {
        if(node == null) return;
        pos(node.left);
        pos(node.right);
        System.out.println(node.val);
    }

    /**
     * 后续遍历非递归
     */
    public void pos2(Node node) {
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            result.add(pop.val);
            if(pop.left!=null) stack.add(pop.left);
            if(pop.right!=null) stack.add(pop.right);
        }
        while(!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    /**
     * 后续遍历炫技版
     * @param node
     */
    public void  pos3(Node node) {
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        Node c;
        while(!stack.isEmpty()) {
            c = stack.peek();
            //左孩子没处理
            if(c.left!=null&&c.left!=node&&c.right!=node) {
                stack.add(node.left);
                //左孩子处理了 右孩子没处理
            }else if(c.right!=null&&c.right!=node) {
                stack.add(node.right);
            }else{
                //都处理了该处理自己了
                node = stack.pop();
                System.out.println(node.val);
            }
        }
    }

    /**
     * 宽度遍历
     * @param node node
     */
    public void width(Node node) {
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll);
            if(poll.left!=null) queue.add(poll.left);
            if(poll.right!=null) queue.add(poll.right);
        }
    }

    /**
     * 获取二叉树的最大宽度 使用Map形式
     * @return
     */
    public int getMaxWidth(Node node) {
        if(node == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node,Integer> width = new HashMap<>();
        width.put(node,1);
        int max = 0;
        int currentLevel = 1;
        int sum = 0;
        while(!queue.isEmpty()) {
            final Node poll = queue.poll();
            int curLevel = width.get(poll);
            if(poll.left!=null) {
                queue.add(poll.left);
                width.put(poll.left,currentLevel+1);
            }
            if(poll.right!=null) {
                queue.add(poll.right);
                width.put(poll.right,currentLevel+1);
            }
            if(curLevel == currentLevel) {
                sum++;
            }else{
                currentLevel++;
                max = Math.max(sum,max);
                sum = 1;
            }
        }
        max = Math.max(sum,max);
        return max;
    }

    /**
     * 获取二叉树最大宽度非Map
     * @param node node
     * @return
     */
    public int getMaxWidth2(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        int currentSum = 0;
        Node curEnd = node,nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            final Node cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            currentSum++;
            if(cur == curEnd) {
                max = Math.max(max,currentSum);
                curEnd = nextEnd;
                currentSum = 0;
            }
        }
        return max;
    }

    //二叉树序列化
    public void treeSerial(TreeNode node ,Queue<Integer> queue) {
        if(node == null) {
            queue.add(null);
        }else{
            queue.add(node.val);
            treeSerial(node.left,queue);
            treeSerial(node.right,queue);
        }
    }

    public Node rebuildQueue(Queue<Integer> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        return buildNodeByQueue(queue);
    }

    private Node buildNodeByQueue(Queue<Integer> queue) {
        final Integer poll = queue.poll();
        if(poll == null) {
            return null;
        }
        Node node = new Node(poll);
        node.left = buildNodeByQueue(queue);
        node.right = buildNodeByQueue(queue);
        return node;
    }

    /**
     * 纸条打印
     */
    public void printPaper(int N) {
        realPrint(1,N,true);
    }

    // i 当前是第几层 N总层数 down是凹
    public void realPrint(int i,int N,boolean down) {
        if(i > N) {
            return;
        }
        realPrint(i+1,N,true);
        System.out.println(down?"凹":"凸");
        realPrint(i+1,N,false);
    }

    public static void main(String[] args) {
        new BinaryTree().printPaper(3);
    }

}
