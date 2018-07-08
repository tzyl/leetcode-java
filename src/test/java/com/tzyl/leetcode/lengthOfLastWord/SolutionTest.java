package com.tzyl.leetcode.lengthOfLastWord;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.lengthOfLastWord("Hello world"), is(5));
    }

    @Test
    public void testOneWord() {
        assertThat(solver.lengthOfLastWord("only"), is(4));
    }

    @Test
    public void testNoLastWord() {
        assertThat(solver.lengthOfLastWord(""), is(0));
        assertThat(solver.lengthOfLastWord(" "), is(0));
    }

    @Test
    public void testTrailingSpace() {
        assertThat(solver.lengthOfLastWord("a "), is(1));
        assertThat(solver.lengthOfLastWord(" a"), is(1));
        assertThat(solver.lengthOfLastWord(" a "), is(1));
    }

}
