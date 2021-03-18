package com.kevin.leecode.godzuo.recursion;

/**
 * @author kevin lau
 */
public class Hanota {

    public static void main(String[] args) {
        hanota(3,"左","右","中");
    }

    public static void hanota(int N, String from, String to, String by) {
        if (N == 1) {
            System.out.println(from + " -> " + to);
            return;
        }
        hanota(N-1,from,by,to);
        hanota(1,from,to,by);
        hanota(N-1,by,to,from);
    }
}
