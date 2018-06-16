/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
package com.tzyl.leetcode.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        BitSet seen = new BitSet();
        Arrays.sort(nums);
        permuteUnique(nums, current, seen, permutations);
        return permutations;
    }

    private void permuteUnique(int[] nums, List<Integer> current, BitSet seen, List<List<Integer>> permutations) {
        if (seen.cardinality() == nums.length) {
            permutations.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (seen.get(i)) {
                    // Already used in the current permutation.
                    continue;
                } else if (i + 1 < nums.length && nums[i + 1] == nums[i] && !seen.get(i + 1)) {
                    // Move to the furthest identical element not used to prevent duplicate permutations.
                    continue;
                } else {
                    // Place current element in current permutation
                    seen.set(i);
                    current.add(nums[i]);
                    permuteUnique(nums, current, seen, permutations);
                    // Remove current element from current permutation
                    seen.clear(i);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
