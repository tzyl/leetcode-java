package com.tzyl.leetcode.countAndSay;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBaseCase() {
        assertThat(solver.countAndSay(1), is(equalTo("1")));
    }

    @Test
    public void testExample() {
        assertThat(solver.countAndSay(4), is(equalTo("1211")));
    }

    @Test
    public void testLargeCase() {
        assertThat(solver.countAndSay(20), is(equalTo("11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211")));
    }
}
