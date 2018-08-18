package com.tzyl.leetcode.textJustification;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expected = Arrays.asList(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        assertEquals(expected, solver.fullJustify(words, maxWidth));
    }
}
