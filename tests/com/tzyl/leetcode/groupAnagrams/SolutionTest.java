package com.tzyl.leetcode.groupAnagrams;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        assertThat(solver.groupAnagrams(strs), containsInAnyOrder(
                containsInAnyOrder("ate", "eat", "tea"),
                containsInAnyOrder("nat", "tan"),
                containsInAnyOrder("bat")
        ));
    }
}
