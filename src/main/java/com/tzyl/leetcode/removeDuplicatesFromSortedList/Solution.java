/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 */
package com.tzyl.leetcode.removeDuplicatesFromSortedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oneBeforeHead = new ListNode(head.val - 1);
        oneBeforeHead.next = head;

        ListNode current = head;
        ListNode previous = oneBeforeHead;

        while (current != null) {
            if (sameValueAsNextNode(current)) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return oneBeforeHead.next;
    }

    private boolean sameValueAsNextNode(ListNode current) {
        return current.next != null && current.val == current.next.val;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
