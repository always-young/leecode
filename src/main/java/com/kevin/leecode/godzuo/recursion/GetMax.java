package com.kevin.leecode.godzuo.recursion;

/**
 * 递归获取最大值
 *
 * @author kevin lau
 */
public class GetMax {

    public static int getMax(int []arr,int L,int R) {
        if(L == R) {
            return arr[L];
        }
        int mid = L +((R-L)>>1);
        int left = getMax(arr,L,mid);
        int right = getMax(arr,mid+1,R);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        int []arr = new int[] {1,3,213,123,2132,43211,1321,1231,2412321};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}
