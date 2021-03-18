package com.kevin.leecode.online.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin lau
 */
public class SimplePractice {

    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <=0) {
            return result;
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        result.add(one);
        List<Integer> prev = one;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int z = i - 2;
            for (int i1 = 0; i1 < z; i1++) {
                list.add(prev.get(i1) + prev.get(i1+1));

            }
            list.add(1);
            prev = list;
            result.add(list);
        }
        return result;
    }

    //杨辉三角2
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        List<Integer> prev = one;
        for (int i = 2; i <= rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int z = i - 2;
            for (int i1 = 0; i1 < z; i1++) {
                list.add(prev.get(i1) + prev.get(i1+1));

            }
            list.add(1);
            prev = list;
        }
        return prev;
    }
}
