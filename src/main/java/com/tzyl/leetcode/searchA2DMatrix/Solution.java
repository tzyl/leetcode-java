/**
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
package com.tzyl.leetcode.searchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = binarySearch(target, getFirstColumn(matrix));
        int column = binarySearch(target, matrix[row]);
        return matrix[row][column] == target;
    }

    private int binarySearch(int target, int[] sorted) {
        int start = 0;
        int end = sorted.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (sorted[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }

    private int[] getFirstColumn(int[][] matrix) {
        int[] firstColumn = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstColumn[i] = matrix[i][0];
        }
        return firstColumn;
    }
}
