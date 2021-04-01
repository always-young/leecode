package com.kevin.leecode.online.middle.str;

import java.util.List;
import java.util.Objects;

/**
 * 子序列和子串问题
 *
 * @author kevin lau
 */
public class ChildStr {

    public boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0) {
            return true;
        }
        if(t == null || t.length() == 0) {
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c,index+1);
            if(index == -1) {
                return false;
            }
        }
        return true;
    }
}
