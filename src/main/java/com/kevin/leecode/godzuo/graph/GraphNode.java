package com.kevin.leecode.godzuo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin lau
 */
public class GraphNode {


    /**
     * 出度
     */
    public int in;

    /**
     * 出度
     */
    public int out;

    public int value;

    public List<GraphNode> nexts;

    public List<Edge> edges;

    public GraphNode(int value) {
        in = 0;
        out = 0;
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNexts(GraphNode node) {
        nexts.add(node);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
