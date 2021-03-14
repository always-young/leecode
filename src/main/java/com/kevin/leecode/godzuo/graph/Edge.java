package com.kevin.leecode.godzuo.graph;

/**
 * @author kevin lau
 */
public class Edge {

    public GraphNode from;

    public GraphNode to;

    public int weight;

    public Edge(GraphNode from, GraphNode to,int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
