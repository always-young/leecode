package com.kevin.leecode.godzuo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kevin lau
 */
public class Dijkstra {


    public Map<GraphNode, Integer> dijkstra(GraphNode node) {
        Map<GraphNode, Integer> result = new HashMap<>();
        Set<GraphNode> set = new HashSet<>();
        result.put(node, 0);
        GraphNode minNode = getMinNode(result, set);
        while (minNode != null) {
            set.add(minNode);
            for (Edge edge : minNode.edges) {
                if (!set.contains(edge.to)) {
                    result.put(edge.to, edge.weight + result.get(minNode));
                } else {
                    result.put(edge.to, Math.min(result.get(minNode) + edge.weight, result.get(edge.to)));
                }
            }
            minNode = getMinNode(result,set);
        }
        return result;
    }

    private GraphNode getMinNode(Map<GraphNode, Integer> result, Set<GraphNode> set) {
        GraphNode node = null;
        int val = Integer.MIN_VALUE;
        for (Map.Entry<GraphNode, Integer> entry : result.entrySet()) {
            if (!set.contains(entry.getKey()) && val < entry.getValue()) {
                node = entry.getKey();
                val = entry.getValue();
            }
        }
        return node;
    }
}
