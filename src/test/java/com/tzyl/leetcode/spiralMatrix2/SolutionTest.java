package com.tzyl.leetcode.spiralMatrix2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5},
        };
        assertThat(solver.generateMatrix(3), is(matrix));
    }

    @Test
    public void testSmallestCase() {
        int[][] matrix = new int[][]{
                new int[]{1},
        };
        assertThat(solver.generateMatrix(1), is(matrix));
    }
}