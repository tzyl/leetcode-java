package com.tzyl.leetcode.nQueens;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.solveNQueens(4), containsInAnyOrder(
                Arrays.asList(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                ),
                Arrays.asList(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                )
        ));
    }

    @Test
    public void testEightQueens() {
        assertThat(solver.solveNQueens(8), hasSize(92));
    }
}
