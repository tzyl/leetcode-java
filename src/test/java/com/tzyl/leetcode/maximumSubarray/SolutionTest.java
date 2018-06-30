package com.tzyl.leetcode.maximumSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[]{-1, 2, -1, 3};
        assertThat(solver.maxSubArray(nums), is(equalTo(4)));
    }

    @Test
    public void testNegativeMaximum() {
        int[] nums = new int[]{-1};
        assertThat(solver.maxSubArray(nums), is(equalTo(-1)));
    }

    @Test
    public void testEmpty() {
        int[] nums = new int[]{};
        assertThrows(IllegalArgumentException.class, () -> solver.maxSubArray(nums));
    }
}