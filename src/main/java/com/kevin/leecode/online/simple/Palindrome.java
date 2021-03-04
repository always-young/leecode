package com.kevin.leecode.online.simple;

/**
 * 判断一个数是否是回文
 *
 * @author Kevin Liu
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121121));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        for (int i = 0; i < str.length()/2 ; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
