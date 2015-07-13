package com.lc.ladder.us.linkedlist;

public class PartitionList {
	/**
     * Create two point (dummy node), one used to store node 
     * which value > x, one for node'value < x.
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode leftDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode right = rightDummy;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
            node = node.next;
        }
        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;
    }
}
