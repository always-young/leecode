package com.kevin.leecode.godzuo.graph;

import com.kevin.leecode.godzuo.unionset.UnionSet;

import java.util.*;

/**
 * @author kevin lau
 */
public class Graph {

    public Map<Integer, GraphNode> nodes;

    public List<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void transferGraph(int[][] martix) {

        for (int[] ints : martix) {
            add(ints[1], ints[2], ints[0]);
        }
    }

    public void add(int from, int to, int weight) {
        if (!nodes.containsKey(from)) {
            nodes.put(from, new GraphNode(from));
        }
        if (!nodes.containsKey(to)) {
            nodes.put(to, new GraphNode(to));
        }
        GraphNode f = nodes.get(from);
        GraphNode t = nodes.get(to);
        Edge edge = new Edge(f, t, weight);
        this.edges.add(edge);
        f.addNexts(t);
        f.addEdge(edge);
        f.out++;
        t.in++;
    }


    /**
     * 广度优先遍历
     */
    private void bfs(GraphNode start) {
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            final GraphNode poll = queue.poll();
            System.out.println(poll.value);
            for (GraphNode next : poll.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                }
            }
        }
    }

    public void bfs(int v) {
        if (this.edges.size() == 0 || nodes.size() == 0) {
            return;
        }
        final GraphNode graphNode = this.nodes.get(v);
        if (graphNode == null) {
            return;
        }
        bfs(graphNode);
    }

    public void dfs(int val) {
        if (this.edges.size() == 0 || nodes.size() == 0) {
            return;
        }
        final GraphNode graphNode = this.nodes.get(val);
        if (graphNode == null) {
            return;
        }
        dfs(graphNode);
    }

    private void dfs(GraphNode node) {
        Set<GraphNode> set = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        set.add(node);
        System.out.println(node.value);
        stack.add(node);
        while (!stack.isEmpty()) {
            final GraphNode pop = stack.pop();
            for (GraphNode next : pop.nexts) {
                if (!set.contains(next)) {
                    stack.add(pop);
                    stack.add(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    /**
     * K算法最小生成树
     *
     * @return
     */
    public List<Edge> minTree() {
        UnionSet<GraphNode> set = new UnionSet<>();
        List<Edge> result = new ArrayList<>();
        set.addAll(this.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.weight));
        queue.addAll(this.edges);
        while (!queue.isEmpty()) {
            final Edge edge = queue.poll();
            if (!set.isSameSet(edge.from, edge.to)) {
                set.union(edge.from, edge.to);
                result.add(edge);
            }
        }
        return result;
    }

    public List<Edge> minTree2() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.weight));
        Set<GraphNode> set = new HashSet<>();
        List<Edge> result = new ArrayList<>();
        for (GraphNode node : this.nodes.values()) {
            queue.addAll(node.edges);
            while (!queue.isEmpty()) {
                Edge poll = queue.poll();
                if (!set.contains(poll.to)) {
                    set.add(poll.to);
                    result.add(poll);
                    queue.addAll(poll.to.edges);
                }
            }
        }
        return result;
    }

}
