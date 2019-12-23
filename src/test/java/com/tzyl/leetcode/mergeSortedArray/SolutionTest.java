package com.tzyl.leetcode.mergeSortedArray;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        int[] expected = new int[]{1, 2, 2, 3, 5, 6};
        solver.merge(nums1, m, nums2, n);
        assertThat(nums1, is(expected));
    }

    @Test
    public void testEmpty() {
        int[] nums1 = new int[]{};
        int m = 0;
        int[] nums2 = new int[]{};
        int n = 0;
        int[] expected = new int[]{};
        solver.merge(nums1, m, nums2, n);
        assertThat(nums1, is(expected));
    }

    @Test
    public void testFirstEmpty() {
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        int[] expected = new int[]{1};
        solver.merge(nums1, m, nums2, n);
        assertThat(nums1, is(expected));
    }

    @Test
    public void testSecondEmpty() {
        int[] nums1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{0};
        int n = 0;
        int[] expected = new int[]{1};
        solver.merge(nums1, m, nums2, n);
        assertThat(nums1, is(expected));
    }

    @Test
    public void testExtraSpaceUninitialized() {
        int[] nums1 = new int[]{2, 4, 6, 0, 0, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{1, 3, 5, 0, 0, 0, 0, 0, 0, 0};
        int n = 3;
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 0, 0, 0, 0};
        solver.merge(nums1, m, nums2, n);
        assertThat(nums1, is(expected));
    }
}
