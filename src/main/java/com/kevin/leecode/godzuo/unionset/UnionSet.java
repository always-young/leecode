package com.kevin.leecode.godzuo.unionset;

import java.util.*;

/**
 * @author kevin lau
 */
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

    public void addAll(Collection<V> list) {
        for (V v : list) {
            Node<V> vNode = new Node<>(v);
            value.put(v, vNode);
            parentMap.put(vNode, vNode);
            sizeMap.put(vNode, 1);
        }
    }

    public int getSize() {
        return sizeMap.size();
    }

    public void addAll(V[] list) {
        for (V v : list) {
            Node<V> vNode = new Node<>(v);
            value.put(v, vNode);
            parentMap.put(vNode, vNode);
            sizeMap.put(vNode, 1);
        }
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


    public static class Node<V> {
        public V v;

        public Node(V v) {
            this.v = v;
        }
    }
}
