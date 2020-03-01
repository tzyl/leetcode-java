/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
package com.tzyl.leetcode.subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int[] nums;
    private List<Integer> current;
    private List<List<Integer>> solutions;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        current = new ArrayList<>();
        solutions = new ArrayList<>();
        solve(0);
        return solutions;
    }

    private void solve(int i) {
        solutions.add(new ArrayList<>(current));
        if (i <= nums.length) {
            for (int j = i; j < nums.length; j++) {
                if (j > i && nums[j] == nums[j - 1]) {
                    // If n duplicate candidates are needed use the first n of them to prevent duplicate solution sets.
                    // 1 1 1 Suppose need two 1s
                    // 1 1 x Use
                    // 1 x 1 Skip
                    // x 1 1 Skip
                    continue;
                }
                current.add(nums[j]);
                solve(j + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
