package com.kevin.leecode.godzuo.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

}
