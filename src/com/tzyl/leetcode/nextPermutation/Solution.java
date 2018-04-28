/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
package com.tzyl.leetcode.nextPermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int start = -1;
        // Find latest index where next number is higher
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                start = i - 1;
            }
        }
        // If no start we are on highest order so reverse to get lowest order
        if (start == -1) {
            reverse(nums);
            return;
        }
        // Find smallest number after start which is higher
        int end = start + 1;
        while (end + 1 < nums.length && nums[end + 1] > nums[start]) {
            end++;
        }
        // Swap into place and sort numbers after by reversing
        swap(nums, start, end);
        reverse(nums, start + 1, nums.length - 1);
    }

    private void reverse(int[] nums) {
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
