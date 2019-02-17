package com.tzyl.leetcode.partitionList;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        ListNode head = generateLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode expected = generateLinkedList(new int[]{1, 2, 2, 4, 3, 5});
        ListNode newHead = solver.partition(head, 3);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testEmpty() {
        ListNode head = null;
        ListNode expected = null;
        ListNode newHead = solver.partition(head, 0);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testAllLessThan() {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode expected = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = solver.partition(head, 6);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testAllGreaterThanEqual() {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode expected = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = solver.partition(head, 1);
        compareLinkedList(newHead, expected);
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
