package com.tzyl.leetcode.substringWithConcatenationOfAllWords;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }),
                containsInAnyOrder(0, 9));
    }

    @Test
    public void testNoMatches() {
        assertThat(solver.findSubstring("abcdefghijkl", new String[0]), is(empty()));
    }

    @Test
    public void testWordsNotSameLength() {
        assertThat(solver.findSubstring("abc", new String[] { "a", "aa"}), is(empty()));
    }

    @Test
    public void testStringNotLongEnough() {
        assertThat(solver.findSubstring("a", new String[] { "ab"}), is(empty()));
    }

    @Test
    public void testLargeCase() {
        assertThat(solver.findSubstring(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
                new String[] { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" }),
                containsInAnyOrder(0));
    }

    @Test
    public void testSameWordMoreThanOnce() {
        assertThat(solver.findSubstring(
                "andandtenand",
                new String[] { "and", "and", "ten" }),
                containsInAnyOrder(0, 3));
    }
}
