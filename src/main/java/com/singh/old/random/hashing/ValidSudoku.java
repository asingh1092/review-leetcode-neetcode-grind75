package com.singh.old.random.hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // check rows
        // check cols
        // check subboxes
        int rows = board.length;
        int cols = board[0].length;
        Set<String> set = new HashSet<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char val = board[row][col];
                if (val != '.') {
                    String r = "r: " + row + val;
                    String c = "c: " + col + val;
                    String s = "r:c " + row / 3 + col / 3 + val;
                    if (set.contains(r) || set.contains(c) || set.contains(s)) {
                        return false;
                    } else {
                        set.add(r);
                        set.add(c);
                        set.add(s);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
