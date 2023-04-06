package com.singh.neetcode.arrayshashing.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    /*
        Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        1. Each row must contain the digit 1-9 without repetition.
        2. Each column must contain the digits 1-9 without repetition
        3. Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

        Note: Don't worry about it being solvable. Only the filled cells need to be validated according to the mentioned rules
     */

    public static boolean isValidSudokuWRONG(char[][] board) {
        // create hashsets for each case.
        Set<Integer> setRows = new HashSet<>();
        Map<Integer, Set<Integer>> setCols = new HashMap<>();
        Map<Integer, Set<Integer>> setSubBox = new HashMap<>();

        int len = board.length;
        // Go over each row, col, and sub-boxes and check and see if char in place exists in the hashset
        for (int row = 0; row < len; row++) {
            if (row % 3 == 0) {
                setSubBox.clear();
            }
            for (int col = 0; col < len; col++) {
                if (!Character.isDigit(board[row][col])) {
                    // this is a space, so continue
                    continue;
                }

                // check rows
                if (setRows.contains(Character.getNumericValue(board[row][col]))) {
                    return false;
                } else {
                    setRows.add(Character.getNumericValue(board[row][col]));
                }

                // check columns
                if (!setCols.containsKey(row)) {
                    setCols.putIfAbsent(row, new HashSet<>());
                }
                Set<Integer> colSet = setCols.get(row);
                if (colSet.contains((Character.getNumericValue(board[row][col])))) {
                    return false;
                } else {
                    colSet.add((Character.getNumericValue(board[row][col])));
                }

                // check subBox
                int colSubBox = col / 3;
                if (!setSubBox.containsKey(colSubBox)) {
                    setSubBox.put(colSubBox, new HashSet<>());
                }
                Set<Integer> subBox = setSubBox.get(colSubBox);
                if (subBox.contains(Character.getNumericValue(board[row][col]))) {
                    return false;
                } else {
                    subBox.add(Character.getNumericValue(board[row][col]));
                }
            }
            // reset row set
            setRows.clear();
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        /*
        {{'.','.','4','.','.','.','6','3','.'}
        ,{'.','.','.','.','.','.','.','.','.'}
        ,{'5','.','.','.','.','.','.','9','.'}
        ,{'.','.','.','5','6','.','.','.','.'}
        ,{'4','.','3','.','.','.','.','.','1'}
        ,{'.','.','.','7','.','.','.','.','.'}
        ,{'.','.','.','5','.','.','.','.','.'}
        ,{'.','.','.','.','.','.','.','.','.'}
        ,{'.','.','.','.','.','.','.','.','.'}}
         */
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(new char[][]
                {{'.', '.', '4', '.', '.', '.', '6', '3', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        , {'5', '.', '.', '.', '.', '.', '.', '9', '.'}
                        , {'.', '.', '.', '5', '6', '.', '.', '.', '.'}
                        , {'4', '.', '3', '.', '.', '.', '.', '.', '1'}
                        , {'.', '.', '.', '7', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '5', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}}));
        System.out.println(3 / 3);
    }

}
