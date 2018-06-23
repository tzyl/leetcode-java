/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */
package com.tzyl.leetcode.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int bestArea = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > bestArea) bestArea = currentArea;
            // We move the pointer of the lower height inwards as we have found the maximum
            // with that pointer at its current position.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return bestArea;
    }
}
