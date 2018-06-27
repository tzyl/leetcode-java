package com.tzyl.leetcode.nQueens2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.totalNQueens(4), is(equalTo(2)));
    }

    @Test
    public void testEightQueens() {
        assertThat(solver.totalNQueens(8), is(equalTo(92)));
    }
}
