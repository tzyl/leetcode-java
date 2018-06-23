package com.tzyl.leetcode.wildcardMatching;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.isMatch("azzzbzc", "a*b?c"), is(true));
    }

    @Test
    public void testEmptyPatternOnlyMatchesEmptyString() {
        assertThat(solver.isMatch("", ""), is(true));
        assertThat(solver.isMatch("a", ""), is(false));
    }

    @Test
    public void testEmptyStringMatchesEmptyPatternOrStar() {
        assertThat(solver.isMatch("", ""), is(true));
        assertThat(solver.isMatch("", "*"), is(true));
        assertThat(solver.isMatch("", "?"), is(false));
        assertThat(solver.isMatch("", "a"), is(false));
    }

    @Test
    public void testQuestionMarkHasToConsume() {
        assertThat(solver.isMatch("abc", "a?c"), is(true));
        assertThat(solver.isMatch("ac", "a?c"), is(false));
    }
}
