package com.kevin.leecode.godzuo.or;

/**
 * 异或代码相关
 */
public class Exo {

    public static void main(String[] args) {
        System.out.println(bitCount(1021));
    }

    /**
     * 第一题不用额外变量交换a b
     */
    public static void swap() {
        int a = 10,b = 1000;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 一个数组有一个数出现了奇数次 有一些数出现了偶数次 找出这个奇数
     */
    public static void findOddNumber(){
        int []arr = new int[] {3,3,3,2,2,4,4,3,3,1,1,5,5};
        int exo =0;
        for (int i : arr) {
            exo ^= i;
        }
        System.out.println(exo);
    }

    /**
     *  提取一个int数二进制最右侧的1
     */
    public static int getRightOne(int n) {
        return n & ((~n) + 1);
    }

    /**
     * 一个数组有两个数出现了奇数次 有一些数出现了偶数次
     *     求出这两个奇数
     */
    public static void  getTwoOddNumber(){
        int []arr = new int[] {133,133,133,2,2,4,4,133,133,21,21,15,15,15};
        //假设第一位是a 第二位是b
        int exo =0;
        for (int i : arr) {
            exo ^= i;
        }
        int firstOne = getRightOne(exo);
        int one = 0;
        for (int i : arr) {
            if((i & firstOne) !=0) {
                one ^= i;
            }
        }
        System.out.println("one=" + one );
        System.out.println("two=" + (exo ^ one));
    }

    /**
     * 统计一个整数二进制中1出现的次数
     * @param n n
     * @return
     */
    public static int bitCount(int n) {
        int count = 0;
        while(n!=0) {
            int rightOne = getRightOne(n);
            count++;
            n^=rightOne;
        }
        return count;
    }
}
