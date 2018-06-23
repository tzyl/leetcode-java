/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
package com.tzyl.leetcode.searchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int pivot = searchPivot(nums);
        return searchTarget(nums, target, pivot);
    }

    /**
     * Finds the index of the pivot (smallest element) in a rotated sorted array.
     * @param nums the rotated sorted array to search
     * @return the index of the smallest element in the array
     */
    private int searchPivot(int[] nums) {
        int p = 0;
        int r = nums.length - 1;
        while (p < r) {
            int q = (p + r) / 2;
            if (nums[q] > nums[r]) {
                p = q + 1;
            } else {
                r = q;
            }
        }
        return p;
    }

    /**
     * Finds the index of the target in a rotated sorted array.
     * @param nums the rotated sorted array to search
     * @param target the target integer to find in the array
     * @param pivot the index of the pivot in the rotated sorted array
     * @return the index of the target in the array if it exists otherwise -1
     */
    private int searchTarget(int[] nums, int target, int pivot) {
        int n = nums.length;
        int p = 0;
        int r = nums.length - 1;
        while (p <= r) {
            int q = (p + r) / 2;
            int rotated = (q + pivot) % n;
            if (nums[rotated] == target) {
                return rotated;
            } else if (nums[rotated] > target) {
                r = q - 1;
            } else {
                p = q + 1;
            }
        }
        return -1;
    }
}
