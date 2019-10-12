package com.tzyl.leetcode.scrambleString;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.isScramble("great", "rgeat"), is(true));
    }

    @Test
    public void testLargeCase() {
        String s = "";
        for (int i = 0; i < 100; i++) {
            s += "a";
        }
        assertThat(solver.isScramble(s, s), is(true));
    }

    @Test
    public void testNotScramble() {
        assertThat(solver.isScramble("abcde", "caebd"), is(false));
    }

    @Test
    public void testEmpty() {
        assertThat(solver.isScramble("", ""), is(true));
    }

    @Test
    public void testDifferentLength() {
        assertThat(solver.isScramble("a", "aa"), is(false));
    }

    @Test
    public void testDifferentLetters() {
        assertThat(solver.isScramble("abc", "bcd"), is(false));
    }
}
