/**
 * 52. N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
package com.tzyl.leetcode.nQueens2;

public class Solution {
	public int totalNQueens(int n) {
		char[][] current = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				current[i][j] = '.';
			}
		}
		return solve(0, current);
	}

	/**
	 * Counts n-queens solutions from row i assuming previous rows are solved.
	 */
	private int solve(int i, char[][] current) {
		if (i == current.length) {
			return 1;
		}
		int total = 0;
		for (int j = 0; j < current.length; j++) {
			if (check(current, i, j)) {
				current[i][j] = 'Q';
				total += solve(i + 1, current);
				current[i][j] = '.';
			}
		}
		return total;
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
}
