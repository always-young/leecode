package com.kevin.leecode.online.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和数字 求出数组中的两个数字加起来等于给定的数
 *
 * @author Kevin Liu
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int []arr = new int[] {2,2};
        final int[] ints = new TwoNumberSum().twoSum(arr,4);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0) {
            return null;
        }
        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.putIfAbsent(nums[i],i);
            int another = target-nums[i];
            if(maps.containsKey(another)&&maps.get(another)!=i) {
                return new int[] {maps.get(another),i};
            }
        }
        return null;
    }
}
