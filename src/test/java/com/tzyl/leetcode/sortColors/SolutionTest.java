package com.tzyl.leetcode.sortColors;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] expected = new int[]{0, 0, 1, 1, 2, 2};
        solver.sortColors(nums);
        assertThat(nums, is(expected));
    }

    @Test
    public void testEmpty() {
        int[] nums = new int[]{};
        int[] expected = new int[]{};
        solver.sortColors(nums);
        assertThat(nums, is(expected));
    }

    @Test
    public void testCheckSwapBack() {
        int[] nums = new int[]{1, 2, 0};
        int[] expected = new int[]{0, 1, 2};
        solver.sortColors(nums);
        assertThat(nums, is(expected));
    }
}
