package com.kevin.leecode.godzuo.greedy;

import java.util.PriorityQueue;

/**
 * 分金条花铜币问题
 *
 * @author kevin lau
 */
public class SplitGold {

    public int splitGold(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int sum = 0;
        while (queue.size() >= 2) {
            int s = queue.poll() + queue.poll();
            sum += s;
            queue.add(s);
        }
        return sum ;
    }
}
