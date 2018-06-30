package com.tzyl.leetcode.spiralMatrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        assertThat(solver.spiralOrder(matrix), is(equalTo(
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
        )));
    }

    @Test
    public void testEmpty() {
        int[][] matrix = new int[][]{};
        assertThat(solver.spiralOrder(matrix), is(equalTo(
                Arrays.asList()
        )));
    }

    @Test
    public void testRectangular() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        };
        assertThat(solver.spiralOrder(matrix), is(equalTo(
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
        )));
    }
}