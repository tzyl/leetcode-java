package com.tzyl.leetcode.rotateList;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode expected = generateLinkedList(new int[]{4, 5, 1, 2, 3});
        ListNode newHead = solver.rotateRight(head, 2);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testEmpty() {
        ListNode head = generateLinkedList(new int[]{});
        ListNode expected = generateLinkedList(new int[]{});
        ListNode newHead = solver.rotateRight(head, 1);
        compareLinkedList(newHead, expected);
    }

    @Test
    public void testOverRotate() {
        ListNode head = generateLinkedList(new int[]{1, 2, 3});
        ListNode expected = generateLinkedList(new int[]{3, 1, 2});
        ListNode newHead = solver.rotateRight(head, 4);
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
