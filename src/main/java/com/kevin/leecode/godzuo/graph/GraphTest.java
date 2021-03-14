package com.kevin.leecode.godzuo.graph;

import java.util.List;

/**
 * @author kevin lau
 */
public class GraphTest {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add(1,2,1);
        graph.add(1,3,2);
        graph.add(1,4,3);
        graph.add(2,5,4);
        graph.add(2,6,5);
        graph.add(4,7,6);
        graph.add(6,9,7);
        graph.add(6,3,8);
        graph.add(9,7,9);
        final List<Edge> edges = graph.minTree();
        edges.forEach(t-> System.out.println(t.weight));
    }
}
