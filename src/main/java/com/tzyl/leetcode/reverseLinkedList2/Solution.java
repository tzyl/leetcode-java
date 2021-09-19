/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * Follow up: Could you do it in one pass?
 */
package com.tzyl.leetcode.reverseLinkedList2;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode previous = null;
        ListNode current = head;
        int i = 1;
        while (i < left) {
            ListNode tmp = current.next;
            previous = current;
            current = tmp;
            i++;
        }

        ListNode beforeStart = previous;
        ListNode newEnd = current;

        previous = null;
        while (i <= right) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
            i++;
        }

        ListNode newStart = previous;
        ListNode afterEnd = current;

        if (left > 1) {
            beforeStart.next = newStart;
        }
        newEnd.next = afterEnd;

        if (left > 1) {
            return head;
        } else {
            return newStart;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
