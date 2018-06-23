package com.tzyl.leetcode.rotateImage;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testOdd() {
        int[][] matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] expected = new int[][] {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 }
        };
        solver.rotate(matrix);
        assertThat(matrix, is(equalTo(expected)));
    }

    @Test
    public void testEven() {
        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int[][] expected = new int[][] {
                { 13, 9, 5, 1 },
                { 14, 10, 6, 2 },
                { 15, 11, 7, 3 },
                { 16, 12, 8, 4 }
        };
        solver.rotate(matrix);
        assertThat(matrix, is(equalTo(expected)));
    }
}
