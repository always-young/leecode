package com.kevin.leecode.online.simple;

/**
 * 给定一个字符串数组 求最大公共子串
 *
 * @author Kevin Liu
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) {
            return "";
        }else if(strs.length == 1) {
            return strs[0];
        }else{
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if(!strs[i].contains(prefix)) {
                    prefix = prefix.substring(0,prefix.length()-1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }
    }
}
