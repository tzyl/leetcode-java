/**
 * 15. 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
package com.tzyl.leetcode.threeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        for (int k = 0; k < n; k++) {
            if (k == 0 || nums[k] != nums[k - 1]) {
                int i = k + 1;
                int j = n - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) j--;
                    else if (sum < 0) i++;
                    else {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[k]);
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplets.add(triplet);
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    }
                }
            }
        }
        return triplets;
    }
}