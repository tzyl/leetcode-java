package com.tzyl.leetcode.maximalRectangle;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        char[][] matrix = new char[][]{
          new char[]{'1', '0', '1', '0', '0'},
          new char[]{'1', '0', '1', '1', '1'},
          new char[]{'1', '1', '1', '1', '1'},
          new char[]{'1', '0', '0', '1', '0'}
        };
        assertThat(solver.maximalRectangle(matrix), is(6));
    }

    @Test
    public void testEmpty() {
        char[][] matrix = new char[][]{};
        assertThat(solver.maximalRectangle(matrix), is(0));
    }
}
