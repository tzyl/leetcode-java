package com.tzyl.leetcode.wordSearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        assertThat(solver.exist(board, "ABCCED"), is(true));
        assertThat(solver.exist(board, "SEE"), is(true));
        assertThat(solver.exist(board, "ABCB"), is(false));
    }

    @Test
    public void testReusePath() {
        char[][] board = new char[][]{
                new char[]{'A', 'B'},
                new char[]{'C', 'D'},
        };
        assertThat(solver.exist(board, "ACDB"), is(true));
        assertThat(solver.exist(board, "ABDC"), is(true));
    }

    @Test
    public void testEmpty() {
        char[][] board = new char[][]{new char[]{}};
        assertThat(solver.exist(board, "A"), is(false));
    }
}
