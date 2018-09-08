package com.tzyl.leetcode.simplifyPath;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.simplifyPath("/a/./b/../../c/"), is("/c"));
    }

    @Test
    public void testRoot() {
        assertThat(solver.simplifyPath("/../"), is("/"));
    }

    @Test
    public void testMultipleSlashes() {
        assertThat(solver.simplifyPath("/home//foo/"), is("/home/foo"));
    }
}
