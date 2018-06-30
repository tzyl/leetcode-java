/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
package com.tzyl.leetcode.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return elements;
        }
        elements.add(matrix[0][0]);
        // Track bounds of unseen elements
        int top = 0;
        int left = 0;
        int bottom  = matrix.length - 1;
        int right = matrix[0].length - 1;
        // Track current position and direction
        int i = 0;
        int j = 0;
        Direction direction = Direction.RIGHT;
        while (bottom >= top && right >= left) {
            switch (direction) {
                case RIGHT:
                    while (j < right) {
                        j++;
                        elements.add(matrix[i][j]);
                    }
                    direction = Direction.DOWN;
                    top++;
                    break;
                case DOWN:
                    while (i < bottom) {
                        i++;
                        elements.add(matrix[i][j]);
                    }
                    direction = Direction.LEFT;
                    right--;
                    break;
                case LEFT:
                    while (j > left) {
                        j--;
                        elements.add(matrix[i][j]);
                    }
                    direction = Direction.UP;
                    bottom--;
                    break;
                case UP:
                    while (i > top) {
                        i--;
                        elements.add(matrix[i][j]);
                    }
                    direction = Direction.RIGHT;
                    left++;
                    break;
            }
        }
        return elements;
    }
}
