package com.kevin.leecode.godzuo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin lau
 */
public class PrintStr {

    public List<String> printStr(String str) {
        List<String> ans = new ArrayList<>();
        print(str, 0, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        new PrintStr().printStr("hello").forEach(System.out::println);
    }

    public void print(String str, int index, List<String> ans, String path) {
        if (index == str.length()) {
            ans.add(path);
            return;
        }
        if (index != str.length() - 1) {
            String no = path;
            print(str, index + 1, ans, no);
        }
        path = path + str.charAt(index);
        print(str, index + 1, ans, path);
    }

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int x = target % 3;
        int y = target / 3;
        if (x == 0) {
            return (int) Math.pow(3, y);
        } else if (x == 1) {
            return 2 * 2 * (int) Math.pow(3, y - 1);
        } else  {
            return 2 * (int) Math.pow(3, y);
        }
    }
}
