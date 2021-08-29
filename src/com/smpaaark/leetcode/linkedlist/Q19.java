package com.smpaaark.leetcode.linkedlist;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 1 && fast != null) {
            fast = fast.next;
            n--;
        }

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode tempNode = fakeHead;
        while (fast.next != null) {
            tempNode = slow;
            slow = slow.next;
            fast = fast.next;
        }

        tempNode.next = slow.next;

        return fakeHead.next;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
