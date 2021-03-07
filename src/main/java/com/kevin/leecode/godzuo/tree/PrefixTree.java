package com.kevin.leecode.godzuo.tree;

/**
 * 前缀树
 *
 * @author kevin lau
 */
public class PrefixTree {

    private TreeNode root;

    public PrefixTree(TreeNode node) {
        root = node;
    }

    public void add(String str) {
        checkStr(str);
        TreeNode node = root;
        node.addPass();
        int seq;
        final char[] chars = str.toCharArray();
        for (char aChar : chars) {
            seq = aChar - 'a';
            TreeNode next = node.getNext(seq);
            if (next == null) {
                next = node.setNext(seq);
            }
            next.addPass();
            node = next;
        }
        node.addEnd();
    }

    public void delete(String str) {
        if (search(str) != 0) {
            TreeNode node = root;
            node.reducePass();
            final char[] chars = str.toCharArray();
            int index;
            for (char aChar : chars) {
                index = aChar - 'a';
                final TreeNode next = node.getNext(index);
                next.reducePass();
                if(next.getPass()==0) {
                    node.clearNext(index);
                    return;
                }
                node = next;
            }
            node.reduceEnd();
        }
    }

    /**
     * 返回一个str加入了几次
     * @param word
     * @return
     */
    public int search(String word) {
        checkStr(word);
        final char[] chars = word.toCharArray();
        int seq;
        TreeNode node = root;
        for (char aChar : chars) {
            seq = aChar - 'a';
            if(node.getNext(seq)==null) {
                return 0;
            }
            node = node.getNext(seq);
        }
        return node.getEnd();
    }

    /**
     * 有几个字符串是以给定参数作为前缀的
     * @param word
     * @return
     */
    public int prefixNumber(String word) {
        checkStr(word);
        final char[] chars = word.toCharArray();
        int seq;
        TreeNode node = root;
        for (char aChar : chars) {
            seq = aChar - 'a';
            if(node.getNext(seq)==null) {
                return 0;
            }
            node = node.getNext(seq);
        }
        return node.getPass();
    }

    private void checkStr(String str) {
        if(str == null || str.length()==0||str.contains(" ")) {
            throw new RuntimeException("str is not illegal");
        }
    }

    public static void main(String[] args) {
        final PrefixTree prefixTree = new PrefixTree(new HashTreeNode());
        prefixTree.add("abc");
        prefixTree.add("abd");
        prefixTree.delete("abc");
        System.out.println(prefixTree.prefixNumber("ab"));

    }

}
