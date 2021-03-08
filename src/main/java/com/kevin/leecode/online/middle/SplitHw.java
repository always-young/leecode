package com.kevin.leecode.online.middle;

import java.util.*;

/**
 * @author kevin lau
 */
public class SplitHw {


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            final List<String> hw = getHw(s, i);
            if(!hw.isEmpty()) {
                res.add(hw);
            }
        }
        return res;
    }

    private List<String> getHw(String s, int i) {
        List<String> list = new ArrayList<>();
        final char[] chars = s.toCharArray();
        for(int index=0;index<chars.length;index++ ) {
            final String s1 = String.valueOf(chars, index, Math.min(chars.length-index,i));
            if(isPalindrome(s1)){
                list.add(s1);
            }
        }
        return list;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2 ; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' ) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                final Character pop = stack.pop();
                if((pop=='('&&c!=')')||(pop=='['&&c!=']')||(pop=='{'&&c!='}')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public int strStr(String haystack, String needle) {
        if(haystack == null||needle==null) return -1;
        return haystack.indexOf(needle);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n-1);
        StringBuilder ans= new StringBuilder();
        int i=0;
        final char[] chars = prev.toCharArray();
        while (i < chars.length) {
            int count = 1;
            int z = i;
            while(z+1<chars.length&&chars[z]==chars[z+1]) {
                count++;
                z++;
            }
            ans.append(count).append(chars[i]);
            i+=count;
        }
        return ans.toString();
    }

    public int climbStairs(int n) {

        int d = 1,t=1;
        for (int i = 2; i <= n; i++) {
            int next =  d+t;
            d = t;
            t = next;
        }
        return t;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) {
            return true;
        }else if(p==null) {
            return false;
        }else if(q==null) {
            return false;
        }else{
            if(p.val == q.val) {
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
            return false;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if(p==null) {
            return false;
        }else if(q==null) {
            return false;
        }else {
            if(p.val == q.val) {
                return symmetric(p.left,q.right) && symmetric(p.right,q.left);
            }
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0) return 1+right;
        if(right==0) return 1+left;
        return 1 + Math.min(left,right);
    }

    public static void main(String[] args) {
       TreeNode p = new TreeNode(1);
       p.left = new TreeNode(2);
       TreeNode q= new TreeNode(1);
       q.left = null;
       q.right = new TreeNode(2);
        System.out.println(isSameTree(p ,q));
    }
}
