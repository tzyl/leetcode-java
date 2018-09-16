package com.tzyl.leetcode.setMatrixZeroes;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[][] matrix = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1},
        };
        int[][] expected = new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1},
        };
        solver.setZeroes(matrix);
        assertThat(matrix, is(expected));
    }

    @Test
    public void testEmpty() {
        int[][] matrix = new int[][]{};
        int[][] expected = new int[][]{};
        solver.setZeroes(matrix);
        assertThat(matrix, is(expected));
    }

    @Test
    public void testOverlap() {
        int[][] matrix = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5},
        };
        int[][] expected = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 4, 5, 0},
                new int[]{0, 3, 1, 0},
        };
        solver.setZeroes(matrix);
        assertThat(matrix, is(expected));
    }
}
