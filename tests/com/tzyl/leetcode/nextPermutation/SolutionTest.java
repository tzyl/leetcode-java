package com.tzyl.leetcode.nextPermutation;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[] { 1, 2, 3 };
        int[] expected = new int[] { 1, 3, 2 };
        solver.nextPermutation(nums);
        assertThat(nums, is(equalTo(expected)));
    }

    @Test
    public void testHighestOrder() {
        int[] nums = new int[] { 3, 2, 1 };
        int[] expected = new int[] { 1, 2, 3 };
        solver.nextPermutation(nums);
        assertThat(nums, is(equalTo(expected)));
    }

    @Test
    public void testSameElements() {
        int[] nums = new int[] { 1, 2, 2 };
        int[] expected = new int[] { 2, 1, 2 };
        solver.nextPermutation(nums);
        assertThat(nums, is(equalTo(expected)));
    }

    @Test
    public void testNonAdjacent() {
        int[] nums = new int[] { 3, 5, 4, 3, 2, 1 };
        int[] expected = new int[] { 4, 1, 2, 3, 3, 5 };
        solver.nextPermutation(nums);
        assertThat(nums, is(equalTo(expected)));
    }

}
