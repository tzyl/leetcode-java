package com.tzyl.leetcode.searchA2DMatrix;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        int target = 3;
        assertThat(solver.searchMatrix(matrix, target), is(true));
    }

    @Test
    public void testEmpty() {
        int[][] matrix = new int[][]{};
        int target = 1;
        assertThat(solver.searchMatrix(matrix, target), is(false));
    }

    @Test
    public void testMissing() {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        int target = 13;
        assertThat(solver.searchMatrix(matrix, target), is(false));
    }
}
