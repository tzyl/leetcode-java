/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
package com.tzyl.leetcode.spiralMatrix2;

public class Solution {
    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        int x = 2;
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
                        matrix[i][j] = x;
                        x++;
                    }
                    direction = Direction.DOWN;
                    top++;
                    break;
                case DOWN:
                    while (i < bottom) {
                        i++;
                        matrix[i][j] = x;
                        x++;
                    }
                    direction = Direction.LEFT;
                    right--;
                    break;
                case LEFT:
                    while (j > left) {
                        j--;
                        matrix[i][j] = x;
                        x++;
                    }
                    direction = Direction.UP;
                    bottom--;
                    break;
                case UP:
                    while (i > top) {
                        i--;
                        matrix[i][j] = x;
                        x++;
                    }
                    direction = Direction.RIGHT;
                    left++;
                    break;
            }
        }
        return matrix;
    }
}
