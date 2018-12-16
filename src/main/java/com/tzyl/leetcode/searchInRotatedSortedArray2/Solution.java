/**
 * 81. Search in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 *
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 */
package com.tzyl.leetcode.searchInRotatedSortedArray2;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int pivot = findPivot(nums);
        return rotatedBinarySearch(nums, target, pivot);
    }

    private boolean rotatedBinarySearch(int[] nums, int target, int pivot) {
        int n = nums.length;
        int p = 0;
        int r = nums.length - 1;
        while (p <= r) {
            int q = (p + r) / 2;
            int rotated = (q + pivot) % n;
            if (nums[rotated] == target) {
                return true;
            } else if (nums[rotated] > target) {
                r = q - 1;
            } else {
                p = q + 1;
            }
        }
        return false;
    }

    private int findPivot(int[] nums) {
        int p = 0;
        int r = nums.length - 1;
        while (p < r) {
            if (nums[p] == nums[r]) {
                // Revert to worst case linear here due to duplicates.
                p++;
            } else {
                int q = (p + r) / 2;
                if (nums[q] > nums[r]) {
                    p = q + 1;
                } else {
                    r = q;
                }
            }
        }
        return p;
    }
}
