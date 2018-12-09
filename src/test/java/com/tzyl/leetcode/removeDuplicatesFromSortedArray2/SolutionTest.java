package com.tzyl.leetcode.removeDuplicatesFromSortedArray2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int len = solver.removeDuplicates(nums);
        assertThat(len, is(5));
        assertThat(nums[0], is(1));
        assertThat(nums[1], is(1));
        assertThat(nums[2], is(2));
        assertThat(nums[3], is(2));
        assertThat(nums[4], is(3));
    }

    @Test
    public void testEmpty() {
        int[] nums = new int[]{};
        int len = solver.removeDuplicates(nums);
        assertThat(len, is(0));
    }

    @Test
    public void testOne() {
        int[] nums = new int[]{1};
        int len = solver.removeDuplicates(nums);
        assertThat(len, is(1));
    }

    @Test
    public void testTwo() {
        int[] nums = new int[]{1, 1};
        int len = solver.removeDuplicates(nums);
        assertThat(len, is(2));
    }
}
