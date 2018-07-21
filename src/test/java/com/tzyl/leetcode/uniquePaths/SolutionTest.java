package com.tzyl.leetcode.uniquePaths;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.uniquePaths(7, 3), is(28));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.uniquePaths(1, 1), is(1));
    }

    @Test
    public void testLargestCase() {
        assertThat(solver.uniquePaths(101, 3), is(5151));
    }
}
