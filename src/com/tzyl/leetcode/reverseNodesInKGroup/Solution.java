/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 */
package com.tzyl.leetcode.reverseNodesInKGroup;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // sentinel
        // keep track of one before and one ahead
        // Reverse all intermediate nodes
        // Fix beginning and end
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;
        ListNode before = sentinel;
        while (checkHasKAhead(before, k)) {
            ListNode prev;
            ListNode current = before;
            ListNode next = before.next;
            // Reverse links for next k nodes.
            for (int i = 0; i < k; i++) {
                // Advance to next node.
                prev = current;
                current = next;
                next = next.next;
                // Reverse current node link.
                current.next = prev;
            }
            // Fix start and end of k group.
            // Point the new tail of the k group to next.
            ListNode newBefore = before.next;
            newBefore.next = next;
            // Point the before node to the new head of the k group.
            before.next = current;
            // Move before node for next k group.
            before = newBefore;
        }
        return sentinel.next;
    }

    private boolean checkHasKAhead(ListNode node, int k) {
        for (int i = 0; i <= k; i++) {
            if (node == null) return false;
            node = node.next;
        }
        return true;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
