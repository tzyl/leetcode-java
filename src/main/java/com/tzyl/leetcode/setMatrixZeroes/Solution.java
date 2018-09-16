/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 *
 * Follow up:
 *
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
package com.tzyl.leetcode.setMatrixZeroes;

public class Solution {
    private int[][] matrix;
    private int m;
    private int n;
    private boolean firstColumnShouldBeZeroes;

    /**
     * O(mn) solution with O(1) extra space using first column to store information about zero rows.
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        this.m = matrix.length;
        this.n =  matrix[0].length;
        this.firstColumnShouldBeZeroes = false;

        checkFirstColumn();
        scanAndFillOtherColumns();
        fillRows();
        if (firstColumnShouldBeZeroes) {
            fillColumnWithZeroes(0);
        }
    }

    private void checkFirstColumn() {
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                firstColumnShouldBeZeroes = true;
                return;
            }
        }
    }

    private void scanAndFillOtherColumns() {
        for (int column = 1; column < n; column++) {
            boolean thisColumnShouldBeZeroes = false;
            for (int row = 0; row < m; row++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    thisColumnShouldBeZeroes = true;
                }
            }
            if (thisColumnShouldBeZeroes) {
                fillColumnWithZeroes(column);
            }
        }
    }

    private void fillRows() {
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                fillRowWithZeroes(row);
            }
        }
    }

    private void fillColumnWithZeroes(int column) {
        for (int row = 0; row < m; row++) {
            matrix[row][column] = 0;
        }
    }

    private void fillRowWithZeroes(int row) {
        for (int column = 0; column < n; column++) {
            matrix[row][column] = 0;
        }
    }
}
