package com.kevin.leecode.online.simple;

/**
 * 整数反转 考虑超出范围
 *
 * @author Kevin Liu
 */
public class NumReverse {

    public int reverse(int x) {
            if (x == 0) {
                return 0;
            }
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
    }
}
