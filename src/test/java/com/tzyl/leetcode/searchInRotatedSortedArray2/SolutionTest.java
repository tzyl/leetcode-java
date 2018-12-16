package com.tzyl.leetcode.searchInRotatedSortedArray2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testPivotAtStart() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 1;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testPivotAtEnd() {
        int[] nums = new int[]{2, 3, 4, 5, 1};
        int target = 1;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testPivotInFirstHalf() {
        int[] nums = new int[]{1, 2, 1, 1, 1};
        int target = 2;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testPivotInSecondHalf() {
        int[] nums = new int[]{1, 1, 1, 2, 1};
        int target = 2;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testRepeated() {
        int[] nums = new int[]{1, 1};
        int target = 1;
        assertThat(solver.search(nums, target), is(true));
    }

    @Test
    public void testNotFound() {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        assertThat(solver.search(nums, target), is(false));
    }

    @Test
    public void testEmpty() {
        int[] nums = new int[]{};
        int target = 1;
        assertThat(solver.search(nums, target), is(false));
    }
}
