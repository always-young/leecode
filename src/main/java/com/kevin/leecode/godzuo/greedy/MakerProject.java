package com.kevin.leecode.godzuo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kevin lau
 */
public class MakerProject {

    public int makeProject(int[] cost, int[] profit, int w, int k) {
        if (cost == null || profit == null || cost.length != profit.length || w <= 0) {
            return 0;
        }
        PriorityQueue<Project> max = new PriorityQueue<>((t1, t2) -> t2.profit - t1.profit);
        PriorityQueue<Project> min = new PriorityQueue<>(Comparator.comparingInt(t -> t.cost));
        for (int i = 0; i < cost.length; i++) {
            Project p = new Project(cost[i], profit[i]);
            min.add(p);
        }
        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && w>=min.peek().cost) {
                    max.add(min.poll());
            }
            if(max.isEmpty()) {
                return w;
            }
            final Project poll = max.poll();
            w += poll.profit;
        }
        return w;
    }

    public static class Project {
        public int cost;
        public int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
}
