/**
 * 37. Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */
package com.tzyl.leetcode.sudokuSolver;

import java.util.BitSet;

public class Solution {
    private final BitSet[] rows = new BitSet[9];
    private final BitSet[] columns = new BitSet[9];
    private final BitSet[] boxes = new BitSet[9];

    public void solveSudoku(char[][] board) {
        // Initialize row, column, box trackers
        for (int i = 0; i < 9; i++) {
            rows[i] = new BitSet(10);
            columns[i] = new BitSet(10);
            boxes[i] = new BitSet(10);
        }
        // Fill trackers with initial numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    set(board, board[i][j] - '0', i, j);
                }
            }
        }
        solve(board, 0);
    }

    private boolean solve(char[][] board, int cell) {
        if (cell >= 81) {
            return true;
        }

        int i = cell / 9;
        int j = cell % 9;
        if (board[i][j] != '.') {
            // Already filled in, move on to next cell.
            return solve(board, cell + 1);
        }

        for (int x = 1; x <= 9; x++) {
            if (isValid(board, x, i, j)) {
                // Try fill in board with x and update trackers
                set(board, x, i, j);
                if (solve(board, cell + 1)) {
                    return true;
                } else {
                    // Unsolvable, roll back change.
                    clear(board, x, i, j);
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int x, int i, int j) {
        if (rows[i].get(x) || columns[j].get(x) || boxes[getBoxIndex(i, j)].get(x)) {
            return false;
        }
        return true;
    }

    private void set(char[][] board, int x, int i, int j) {
        board[i][j] = Character.forDigit(x, 10);
        rows[i].set(x);
        columns[j].set(x);
        boxes[getBoxIndex(i, j)].set(x);
    }

    private void clear(char[][] board, int x, int i, int j) {
        board[i][j] = '.';
        rows[i].clear(x);
        columns[j].clear(x);
        boxes[getBoxIndex(i, j)].clear(x);
    }

    private int getBoxIndex(int i, int j) {
        return 3 * (i / 3) + (j / 3);
    }
}
