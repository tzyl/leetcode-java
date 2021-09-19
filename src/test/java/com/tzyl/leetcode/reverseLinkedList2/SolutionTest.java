package com.tzyl.leetcode.reverseLinkedList2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SolutionTest {

    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode expected = generateLinkedList(new int[]{1, 4, 3, 2, 5});
        ListNode newHead = solver.reverseBetween(head, 2, 4);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testSingleElementWholeList() {
        ListNode head = generateLinkedList(new int[]{5});
        ListNode expected = generateLinkedList(new int[]{5});
        ListNode newHead = solver.reverseBetween(head, 1, 1);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testSingleElementPartialList() {
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6}), 1, 1),
                generateLinkedList(new int[]{4, 5, 6}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6}), 2, 2),
                generateLinkedList(new int[]{4, 5, 6}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6}), 3, 3),
                generateLinkedList(new int[]{4, 5, 6}));
    }

    @Test
    public void testTwoElementsWholeList() {
        ListNode head = generateLinkedList(new int[]{5, 6});
        ListNode expected = generateLinkedList(new int[]{6, 5});
        ListNode newHead = solver.reverseBetween(head, 1, 2);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testTwoElementsPartialList() {
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7}), 1, 2),
                generateLinkedList(new int[]{5, 4, 6, 7}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7}), 2, 3),
                generateLinkedList(new int[]{4, 6, 5, 7}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7}), 3, 4),
                generateLinkedList(new int[]{4, 5, 7, 6}));
    }

    @Test
    public void testThreeElementsWholeList() {
        ListNode head = generateLinkedList(new int[]{4, 5, 6});
        ListNode expected = generateLinkedList(new int[]{6, 5, 4});
        ListNode newHead = solver.reverseBetween(head, 1, 3);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testThreeElementsPartialList() {
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7, 8}), 1, 3),
                generateLinkedList(new int[]{6, 5, 4, 7 ,8}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7, 8}), 2, 4),
                generateLinkedList(new int[]{4, 7, 6, 5 ,8}));
        compareLinkedList(
                solver.reverseBetween(generateLinkedList(new int[]{4, 5, 6, 7, 8}), 3, 5),
                generateLinkedList(new int[]{4, 5, 8, 7 ,6}));
    }

    private void compareLinkedList(ListNode head1, ListNode head2) {
        while (head1 != null) {
            assertThat(head1.val, is(head2.val));
            head1 = head1.next;
            head2 = head2.next;
        }
        assertThat(head2, is(nullValue()));
    }

    private ListNode generateLinkedList(int[] values) {
        ListNode oneBeforeStart = new ListNode(0);
        ListNode current = oneBeforeStart;
        for (int val : values) {
            ListNode next = new ListNode(val);
            current.next = next;
            current = next;
        }
        return oneBeforeStart.next;
    }
}
