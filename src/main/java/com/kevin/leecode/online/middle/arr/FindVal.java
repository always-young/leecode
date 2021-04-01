package com.kevin.leecode.online.middle.arr;

/**
 * @author kevin lau
 */
public class FindVal {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0||matrix[0]==null||matrix[0].length ==0) {
            return false;
        }
        int y = 0;
        int x = matrix[0].length-1;
        while (x >= 0 && y < matrix.length) {
            if(matrix[y][x] == target) {
                return true;
            }else if(matrix[y][x] < target){
                y++;
            }else{
                x--;
            }
        }
        return false;
    }
}
