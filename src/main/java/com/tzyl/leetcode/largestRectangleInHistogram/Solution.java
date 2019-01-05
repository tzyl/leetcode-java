/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *  
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *  
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *  
 *
 * Example:
 *
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 */
package com.tzyl.leetcode.largestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * O(n) solution using stack to keep track of the closest index to the left which
     * is at a shorter height.
     */
    public int largestRectangleArea(int[] heights) {
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
