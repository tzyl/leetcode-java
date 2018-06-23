/**
 * 18. 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
package com.tzyl.leetcode.fourSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length;
        for (int r = 0; r < n; r++) {
            if (r == 0 || nums[r] != nums[r - 1]) {
                for (int s = r + 1; s < n; s++) {
                    if (s == r + 1 || nums[s] != nums[s - 1]) {
                        int i = s + 1;
                        int j = n - 1;
                        while (i < j) {
                            int sum = nums[i] + nums[j] + nums[r] + nums[s];
                            if (sum > target) j--;
                            else if (sum < target) i++;
                            else {
                                List<Integer> quadruplet = new ArrayList<>();
                                quadruplet.add(nums[r]);
                                quadruplet.add(nums[s]);
                                quadruplet.add(nums[i]);
                                quadruplet.add(nums[j]);
                                quadruplets.add(quadruplet);
                                while (i < j && nums[i] == nums[i + 1]) i++;
                                while (i < j && nums[j] == nums[j - 1]) j--;
                                i++;
                                j--;
                            }
                        }
                    }
                }
            }
        }
        return quadruplets;
    }
}