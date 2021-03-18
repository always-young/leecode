package com.kevin.leecode.online.simple;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单提集合
 *
 * @author kevin lau
 */
public class SimplePlainTest {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int count = 1;
        int index = chars.length - 2;
        while (index >= 0 && chars[index] != ' ') {
            index--;
            count++;
        }
        return count;
    }

    public static String addBinary(String a, String b) {
        int p = a.length() - 1, q = b.length() - 1;
        int scale = 0;
        StringBuilder builder = new StringBuilder();
        int sum;
        while (p >= 0 && q >= 0) {
            sum = scale + (a.charAt(p) - '0') + (b.charAt(q) - '0');
            scale = sum / 2;
            builder.append(sum % 2);
            p--;
            q--;
        }
        while (p >= 0) {
            sum = scale + (a.charAt(p) - '0');
            scale = sum / 2;
            builder.append(sum % 2);
            p--;
        }
        while (q >= 0) {
            sum = scale + (b.charAt(q) - '0');
            scale = sum / 2;
            builder.append(sum % 2);
            q--;
        }
        if (scale != 0) {
            builder.append(scale);

        }
        return builder.reverse().toString();
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            sum += climbStairs(i) + climbStairs(n - i);
        }
        return sum;
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (arr.length == 1) {
            return new int[]{1};
        }
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> maps = new HashMap<>();
        int count = 1;
        for (int i : clone) {
            if (maps.get(i) == null) {
                maps.put(i, count++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maps.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new SimplePlainTest().climbStairs(4));
    }

}
