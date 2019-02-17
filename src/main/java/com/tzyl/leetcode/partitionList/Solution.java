/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 */
package com.tzyl.leetcode.partitionList;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode oneBeforeLeft = new ListNode(Integer.MIN_VALUE);
        ListNode oneBeforeRight = new ListNode(Integer.MIN_VALUE);
        ListNode leftEnd = oneBeforeLeft;
        ListNode rightEnd = oneBeforeRight;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                leftEnd.next = current;
                leftEnd = current;
            } else {
                rightEnd.next = current;
                rightEnd = current;
            }
            current = current.next;
        }

        leftEnd.next = oneBeforeRight.next;
        rightEnd.next = null;
        return oneBeforeLeft.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
