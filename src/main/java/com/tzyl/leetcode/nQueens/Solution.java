/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 */
package com.tzyl.leetcode.nQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] current = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current[i][j] = '.';
            }
        }
        solve(0, current, solutions);
        return solutions;
    }

    /**
     * Solves n-queens from row i assuming previous rows are solved.
     */
    private void solve(int i, char[][] current, List<List<String>> solutions) {
        if (i == current.length) {
            solutions.add(convert(current));
        }
        for (int j = 0; j < current.length; j++) {
            if (check(current, i, j)) {
                current[i][j] = 'Q';
                solve(i + 1, current, solutions);
                current[i][j] = '.';
            }
        }
    }

    /**
     * Returns true if a queen can be placed at (i, j) given current board.
     */
    private boolean check(char[][] current, int i, int j) {
        int n = current.length;
        // Check column
        for (int i1 = 0; i1 < n; i1++) {
            if (current[i1][j] == 'Q') {
                return false;
            }
        }
        // Check row
        for (int j1 = 0; j1 < n; j1++) {
            if (current[i][j1] == 'Q') {
                return false;
            }
        }
        // Check diagonal
        int i1;
        int j1;
        if (i < j) {
            i1 = 0;
            j1 = j - i;
        } else {
            i1 = i - j;
            j1 = 0;
        }
        while (i1 < n && j1 < n) {
            if (current[i1][j1] == 'Q') {
                return false;
            }
            i1++;
            j1++;
        }
        // Check other diagonal
        if (i + j < n) {
            i1 = i + j;
            j1 = 0;
        } else {
            i1 = n - 1;
            j1 = j - (n - 1 - i);
        }
        while (i1 >= 0 && j1 < n) {
            if (current[i1][j1] == 'Q') {
                return false;
            }
            i1--;
            j1++;
        }
        return true;
    }

    private List<String> convert(char[][] current) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < current.length; i++) {
            solution.add(new String(current[i]));
        }
        return solution;
    }
}
