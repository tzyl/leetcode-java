/**
 * 16. 3Sum Closest
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package com.tzyl.leetcode.threeSumClosest;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) throw new IllegalArgumentException();
        Arrays.sort(nums);
        int n = nums.length;
        int best = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < n; k++) {
            if (k == 0 || nums[k] != nums[k - 1]) {
                int i = k + 1;
                int j = n - 1;
                while (i < j) {
                    int currentSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(currentSum - target) < Math.abs(best - target)) {
                        best = currentSum;
                    }
                    if (currentSum < target) i++;
                    else if (currentSum > target) j--;
                    else break;
                }
            }
        }
        return best;
    }
}