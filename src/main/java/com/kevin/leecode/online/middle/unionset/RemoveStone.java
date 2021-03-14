package com.kevin.leecode.online.middle.unionset;

import com.kevin.leecode.godzuo.unionset.UnionSet;

import java.util.*;

/**
 * @author kevin lau
 */
public class RemoveStone {

    public int removeStones(int[][] stones) {
        if(stones == null || stones.length ==0) {
            return 0;
        }
        int sum = 0;
        UnionSet<Stone> set = new UnionSet<>();
        Map<Integer,Stone> iMap = new HashMap<>();
        Map<Integer,Stone> jMap = new HashMap<>();
        List<Stone> allStone = new ArrayList<>();
        for (int[] stone : stones) {
            Stone s = new Stone(stone[0], stone[1]);
            allStone.add(s);
            set.add(s);
        }
        for (Stone stone : allStone) {
            if(!iMap.containsKey(stone.i)) {
                iMap.put(stone.i,stone);
            }else{
                set.union(stone,iMap.get(stone.i));
            }
            if(!jMap.containsKey(stone.j)) {
                jMap.put(stone.j,stone);
            }else{
                set.union(stone,jMap.get(stone.j));
            }
        }
        return allStone.size() - set.getSize();

    }

    public class UnionSet<V> {

        private Map<V, Node<V>> value;

        private Map<Node<V>, Integer> sizeMap;

        private Map<Node<V>, Node<V>> parentMap;

        public UnionSet() {
            value = new HashMap<>();
            sizeMap = new HashMap<>();
            parentMap = new HashMap<>();
        }

        public void add(V v) {
            Node<V> vNode = new Node<>(v);
            value.put(v, vNode);
            parentMap.put(vNode, vNode);
            sizeMap.put(vNode, 1);
        }


        public int getSize() {
            return sizeMap.size();
        }


        private Node<V> findFather(Node<V> v) {
            Stack<Node<V>> stack = new Stack<>();
            while (parentMap.get(v) != v) {
                stack.add(v);
                v = parentMap.get(v);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), v);
            }
            return v;
        }

        public boolean isSameSet(V v1, V v2) {
            if (!value.containsKey(v1) || !value.containsKey(v2)) {
                return false;
            }
            return findFather(value.get(v1)) == findFather(value.get(v2));
        }

        public void union(V v1, V v2) {
            if (!value.containsKey(v1) || !value.containsKey(v2)) {
                return;
            }
            if (isSameSet(v1, v2)) {
                return;
            }
            Node<V> v1F = findFather(value.get(v1)), v2F = findFather(value.get(v2));
            int v1Size = sizeMap.get(v1F);
            int v2Size = sizeMap.get(v2F);
            if (v1Size > v2Size) {
                parentMap.put(v2F, v1F);
                sizeMap.put(v1F, v1Size + v2Size);
                sizeMap.remove(v2F);
            } else {
                parentMap.put(v1F, v2F);
                sizeMap.put(v2F, v1Size + v2Size);
                sizeMap.remove(v1F);
            }
        }

    }

    public static class Node<V> {
        public V v;

        public Node(V v) {
            this.v = v;
        }
    }

    public static class Stone {
        public int i;
        public int j;

        public Stone(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
