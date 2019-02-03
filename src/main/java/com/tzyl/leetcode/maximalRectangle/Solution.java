/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 */
package com.tzyl.leetcode.maximalRectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * O(n^2) solution using largest rectangle area in histogram.
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int bestArea = 0;
        // Row by row find largest rectangle in histogram.
        for (int i = 0; i < m; i++) {
            // Update heights to histogram with base at row i.
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else if (matrix[i][j] == '0') {
                    heights[j] = 0;
                }
            }
            // Find largest rectangle area with base at row i.
            bestArea = Math.max(bestArea, largestRectangleArea(heights));
        }
        return bestArea;
    }

    /**
     * O(n) solution using stack to keep track of the closest index to the left which
     * is at a shorter height.
     */
    private int largestRectangleArea(int[] heights) {
        int bestArea = 0;
        // Each bar index initially goes on the pending stack.
        //
        // A bar index can be confirmed and the greatest area involving the bar at its
        // height can be calculated when we know the closest bar index to the left and
        // to the right at a shorter height.
        //
        // The stack maintains the invariant that it contains bar indexes of ascending
        // height otherwise we can confirm previous pending bars on the stack.
        Deque<Integer> pending = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!pending.isEmpty() && heights[pending.peek()] > heights[i]) {
                int confirmedIndex = pending.pop();
                int leftIndex = pending.isEmpty() ? 0 : pending.peek() + 1;
                int rightIndex = i - 1;
                int area = heights[confirmedIndex] * (rightIndex - leftIndex + 1);
                if (area > bestArea) {
                    bestArea = area;
                }
            }
            pending.push(i);
        }
        // Clear out remaining pending indexes at end.
        while (!pending.isEmpty()) {
            int confirmedIndex = pending.pop();
            int leftIndex = pending.isEmpty() ? 0 : pending.peek() + 1;
            int rightIndex = heights.length - 1;
            int area = heights[confirmedIndex] * (rightIndex - leftIndex + 1);
            if (area > bestArea) {
                bestArea = area;
            }
        }
        return bestArea;
    }
}
