package com.tzyl.leetcode.validSudoku;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testValid() {
        assertThat(solver.isValidSudoku(new char[][] {
                { '5','3','.','.','7','.','.','.','.' },
                { '6','.','.','1','9','5','.','.','.' },
                { '.','9','8','.','.','.','.','6','.' },
                { '8','.','.','.','6','.','.','.','3' },
                { '4','.','.','8','.','3','.','.','1' },
                { '7','.','.','.','2','.','.','.','6' },
                { '.','6','.','.','.','.','2','8','.' },
                { '.','.','.','4','1','9','.','.','5' },
                { '.','.','.','.','8','.','.','7','9' }
        }), is(true));
    }

    @Test
    public void testInvalid() {
        assertThat(solver.isValidSudoku(new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }), is(false));
    }


}

