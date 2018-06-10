/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 */
package com.tzyl.leetcode.jumpGame2;

public class Solution {
    /**
     * O(n) solution with O(1) extra space.
     */
    public int jump(int[] nums) {
        // Three pointers minimumJumps, currentMax and nextMax.
        // currentMax represents the max possible index reachable with minimumJumps.
        // nextMax represents the max possible index reachable with minimumJumps + 1.
        // The minimum number of jumps will follow a sequences of 1s, 2s, 3s, ...
        int minimumJumps = 0;
        int nextMax = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == currentMax) {
                // Now we have finished calculating nextMax for minimumJumps + 1.
                minimumJumps++;
                currentMax = nextMax;
            }
        }
        return minimumJumps;
    }
}
