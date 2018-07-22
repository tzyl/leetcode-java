package com.tzyl.leetcode.uniquePaths2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[][] obstacles = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
        };
        assertThat(solver.uniquePathsWithObstacles(obstacles), is(2));
    }

    @Test
    public void testSmallestCase() {
        int[][] obstacles = new int[][]{new int[]{1}};
        assertThat(solver.uniquePathsWithObstacles(obstacles), is(0));
    }
}
