package com.kevin.leecode.online.middle.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * 全排列
 *
 * @author kevin lau
 */
public class PrintAll {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null | nums.length ==0) {
            return list;
        }
        process(nums,list,0);
        return list;
    }

    private void process(int[] nums, List<List<Integer>> list, int index) {
        if (index == nums.length) {
            List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
            list.add(l);
            return;
        }
        boolean []visited  = new boolean[20];
        for (int j = index; j < nums.length; j++) {
            if(!visited[nums[j]+9]) {
                visited[nums[j]+9] = true;
                swap(nums,j,index);
                process(nums,list,index+1);
                swap(nums,j,index);
            }

        }
    }

    private void swap(int[] nums, int j, int index) {
        int i = nums[j];
        nums[j] = nums[index];
        nums[index] = i;
    }
}
