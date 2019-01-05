package com.tzyl.leetcode.largestRectangleInHistogram;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        assertThat(solver.largestRectangleArea(heights), is(10));
    }

    @Test
    public void testEmpty() {
        int[] heights = new int[]{};
        assertThat(solver.largestRectangleArea(heights), is(0));
    }

    @Test
    public void testSingleHeight() {
        int[] heights = new int[]{1};
        assertThat(solver.largestRectangleArea(heights), is(1));
    }

    @Test
    public void testAllAscending() {
        int[] heights = new int[]{1, 2, 3, 4, 5};
        assertThat(solver.largestRectangleArea(heights), is(9));
    }
}
