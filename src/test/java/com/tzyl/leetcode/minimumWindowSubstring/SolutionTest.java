package com.tzyl.leetcode.minimumWindowSubstring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.minWindow("ADOBECODEBANC", "ABC"), is("BANC"));
    }

    @Test
    public void testEmpty() {
        assertThat(solver.minWindow("", ""), is(""));
    }

    @Test
    public void testNoSuchWindow() {
        assertThat(solver.minWindow("ABC", "BCD"), is(""));
    }

    @Test
    public void testRepeatCharacters() {
        assertThat(solver.minWindow("ABAC", "AA"), is("ABA"));
    }

    @Test
    public void testRepeatCharactersNotPossible() {
        assertThat(solver.minWindow("A", "AA"), is(""));
    }
}
