/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 */
package com.tzyl.leetcode.removeDuplicatesFromSortedList2;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oneBeforeHead = new ListNode(head.val - 1);
        oneBeforeHead.next = head;

        ListNode current = head;
        ListNode previous = oneBeforeHead;
        int previousSeenValue = previous.val;

        while (current != null) {
            if (current.val == previousSeenValue || sameValueAsNextNode(current)) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            previousSeenValue = current.val;
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
