/**
 * 34. Search for a Range
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
package com.tzyl.leetcode.searchForARange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int[] solution = new int[2];
        solution[0] = searchTarget(nums, target, Direction.START);
        solution[1] = searchTarget(nums, target, Direction.END);
        return solution;
    }

    private int searchTarget(int[] nums, int target, Direction direction) {
        int p = 0;
        int r = nums.length - 1;

        while (p < r) {
            // Round down if looking for start and round up if looking for end to ensure we terminate.
            int q = (direction == Direction.START) ? (p + r) / 2 : (p + r + 1) / 2;;

            if (nums[q] < target) {
                p = q + 1;
            } else if (nums[q] > target) {
                r = q - 1;
            } else if (direction == Direction.START) {
                r = q;
            } else {
                p = q;
            }
        }

        if (p != r || nums[p] != target) {
            return -1;
        }
        return p;
    }
}

enum Direction {
    START,
    END
}
