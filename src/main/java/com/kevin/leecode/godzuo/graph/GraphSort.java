package com.kevin.leecode.godzuo.graph;

import java.util.*;

/**
 * 拓扑排序 利用入度为0来判断
 *
 * @author kevin lau
 */
public class GraphSort {

    public void graphSort(Graph graph) {
        //入度的Map
        Map<GraphNode, Integer> maps = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        for (GraphNode value : graph.nodes.values()) {
            maps.put(value, value.in);
            if (value.in == 0) {
                queue.add(value);
            }
        }
        while (!queue.isEmpty()) {
            GraphNode poll = queue.poll();
            System.out.println(poll.value);
            for (GraphNode next : poll.nexts) {
                maps.put(next, maps.get(next) - 1);
                if (maps.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
