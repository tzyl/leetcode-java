/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
package com.tzyl.leetcode.trappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] maxFromLeft = new int[n];
        int[] maxFromRight= new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxFromLeft[i] = height[i];
                continue;
            }
            maxFromLeft[i] = max(maxFromLeft[i - 1], height[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                maxFromRight[i] = height[i];
                continue;
            }
            maxFromRight[i] = max(maxFromRight[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += max(min(maxFromLeft[i], maxFromRight[i]) - height[i], 0);
        }
        return total;
    }

    private int max(int x, int y) {
        return x > y ? x : y;
    }

    private int min(int x, int y) {
        return x < y ? x : y;
    }
}
