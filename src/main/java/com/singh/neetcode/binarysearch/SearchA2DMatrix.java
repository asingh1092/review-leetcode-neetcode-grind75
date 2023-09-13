package com.singh.neetcode.binarysearch;

public class SearchA2DMatrix {

    /*
        Given an m x n integer matrix [matrix] with the follow two props:
            1. Each row is sorted in non-decreasing order
            2. The 1st integer of each row is greater than the last integer of the previous row

        Given an integer target, return true if target is in matrix or false otherwise

        Must write algo in O(log(m*n))
         0   1   2    3
       0 1   3   5    7
       1 10  11  16  20
       2 23  30  34  60

        matrix = [row][col]
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int rowHigh = rowSize - 1;
        int colHigh = colSize - 1;
        while (row <= rowHigh) {
            int midRow = (rowHigh - row) / 2 + row;
            if (target >= matrix[midRow][col] && target <= matrix[midRow][colHigh]) {
                // check row now
                while (col <= colHigh) {
                    int midCol = (colHigh - col) / 2 + col;
                    if (target == matrix[midRow][midCol]) {
                        return true;
                    } else if (target < matrix[midRow][midCol]) {
                        colHigh = midCol - 1;
                    } else {
                        col = midCol + 1;
                    }
                }
            } else if (target < matrix[midRow][col]) {
                rowHigh = midRow - 1;
            } else {
                row = midRow + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 9));
        System.out.println(searchMatrix(matrix, 20));
    }
}
