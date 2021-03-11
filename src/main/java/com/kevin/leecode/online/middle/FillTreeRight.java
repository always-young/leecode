package com.kevin.leecode.online.middle;

import com.kevin.leecode.online.simple.tree.PathSum;
import com.kevin.leecode.online.simple.tree.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * @author kevin lau
 */
public class FillTreeRight {

    public Node connect(Node root) {
        List<List<Node>> result = new ArrayList<>();
        if(root == null) {
            return null;
        }
        Node curEnd = root,nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Node> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll.left!=null) {
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if(poll.right!=null) {
                queue.add(poll.right);
                nextEnd = poll.right;
            }
            level.add(poll);
            if(poll == curEnd) {
                result.add(level);
                curEnd = nextEnd;
                level = new ArrayList<>();
            }
        }
        for (List<Node> nodes : result) {
            for(int i=0;i<nodes.size()-1;i++) { nodes.get(i).next = nodes.get(i+1);
            }
        }
        return root;
     }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        final Node connect = new FillTreeRight().connect(n1);
        System.out.println(connect);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
