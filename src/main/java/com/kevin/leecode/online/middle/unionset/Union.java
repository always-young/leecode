package com.kevin.leecode.online.middle.unionset;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kevin lau
 */
public class Union {


    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if (names == null || names.length == 0 || synonyms == null || synonyms.length == 0) {
            return new String[0];
        }
        Map<String, People> map = new HashMap<>();
        UnionSet set = new UnionSet();
        for (String name : names) {
            final String[] split = name.split("\\(");
            People people = new People(split[0], Integer.parseInt(split[1].substring(0, split[1].length() - 1)));
            map.put(split[0], people);
            set.add(people);
        }

        for (String synonym : synonyms) {
            synonym = synonym.substring(1, synonym.length() - 1);
            final String[] split = synonym.split(",");
            if(map.containsKey(split[0])&&map.containsKey(split[1])) {
                set.union(map.get(split[0]),map.get(split[1]));
            }
        }
        String[] strs = new String[set.sizeMap.size()];
        AtomicInteger i = new AtomicInteger();
        set.sizeMap.forEach((k,v)->{
            strs[i.get()] = k.v.name +"(" + v +")";
            i.getAndIncrement();
        });
        return strs;
    }
    public static class People {
        public String name;

        public int gl;

        public People(String name, int gl) {
            this.name = name;
            this.gl = gl;
        }
    }

    public static class UnionSet {

        private Map<People, Node> value;

        private Map<Node, Integer> sizeMap;

        private Map<Node, Node> parentMap;

        public UnionSet() {
            value = new HashMap<>();
            sizeMap = new HashMap<>();
            parentMap = new HashMap<>();
        }

        public void add(People people) {
            Node vNode = new Node(people);
            value.put(people, vNode);
            parentMap.put(vNode, vNode);
            sizeMap.put(vNode, people.gl);
        }

        public int getSize() {
            return sizeMap.size();
        }

        private Node findFather(Node People) {
            Stack<Node> stack = new Stack<>();
            while (parentMap.get(People) != People) {
                stack.add(People);
                People = parentMap.get(People);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), People);
            }
            return People;
        }

        public boolean isSameSet(People v1, People v2) {
            if (!value.containsKey(v1) || !value.containsKey(v2)) {
                return false;
            }
            return findFather(value.get(v1)) == findFather(value.get(v2));
        }

        public void union(People v1, People v2) {
            if (!value.containsKey(v1) || !value.containsKey(v2)) {
                return;
            }
            if (isSameSet(v1, v2)) {
                return;
            }
            Node v1F = findFather(value.get(v1)), v2F = findFather(value.get(v2));
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

    public static class Node {
        public People v;

        public Node(People v) {
            this.v = v;
        }
    }
}
