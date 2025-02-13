package com.singh.old.grind75.week3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
        1 2 3                  1   2  3  4         1  2  3 4
        4 5 6                  5   6  7  8         5  6  7 8
        7 8 9                  9  10 11 12         9 10 11 12
                                                  13 14 15 16

        1 2 3 6 9 8 7 4 5      1 2 3 4 8 12 11 10 9 5 6 7
        [0,0]                  [0,0]
        [0,1]                  [0,1]
        [0,2]                  [0,2]
        [1,2]                  [0,3]
        [2,2]                  [1,3]
        [2,1]                  [2,3]
        [2,0]                  [2,2]
                               [2,1]
        [1,0]                  [2,0]
        [1,1]
                               [1,0]


     */

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int colBegin = 0;
        List<Integer> ret = new ArrayList<>();

        int rowEnd = matrix[0].length - 1;
        int colEnd = matrix.length - 1;
        if (rowEnd == 0 || colEnd == 0) {
            return ret;
        }
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse right
            for (int j = colBegin; j <= colEnd; j++) {
                ret.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                ret.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    ret.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    ret.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
