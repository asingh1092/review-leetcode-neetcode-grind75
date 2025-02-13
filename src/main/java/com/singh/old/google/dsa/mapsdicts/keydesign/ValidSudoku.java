package com.singh.old.google.dsa.mapsdicts.keydesign;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
        Given a 9x9 board, determine if it is valid based on:

        1. Each row must contain the digits 1- 9 without repetition
        2. Each column must contain the digits 1-9 without repetition
        3. Each of the nine 3x3 sub-boxes of the grid must contain 1-9 without repetition

        // need to check every box so its going to be NxN O(n^2) time with
         1 2 3
        _ _ _             123  456 789
     1  |            123  1,1  1,2  1,3
    2   |            456  2,1  2,2  2,3
    3   |            789  3,1  3,2  3,3

                          1 % 1 + 1 = 1
                          1 % 2  = 1
                          1 % 3  = 1
                          2 % 4 = 2
                          2 % 5 = 2
                          2 % 6 = 2
                          3 % 7 = 3
                          3 % 8 = 3
                          3 % 9 = 3
     */

    public static boolean isValidSudoku(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if (rows != cols) {
            return false;
        }

        Set<String> set = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // check rows
                char number = (char) board[row][col];
                if (number != '.')
                    if (!set.add(number + " in row " + row) ||
                            !set.add(number + " in column " + col) ||
                            !set.add(number + " in block " + row / 3 + "-" + col / 3))
                        return false;
            }
        }
        return true;
    }

}
