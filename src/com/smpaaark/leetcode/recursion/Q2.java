package com.smpaaark.leetcode.recursion;

public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        ListNode prevNode = fakeHead;
        solution(l1, l2, 0, prevNode);

        return fakeHead.next;
    }

    private void solution(ListNode l1, ListNode l2, int carry, ListNode prevNode) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }

        int num1 = l1 != null ? l1.val : 0;
        int num2 = l2 != null ? l2.val : 0;

        int sum = num1 + num2 + carry;
        carry = sum / 10;
        sum %= 10;

        prevNode.next = new ListNode(sum);

        ListNode nextNode1 = l1 != null ? l1.next : null;
        ListNode nextNode2 = l2 != null ? l2.next : null;
        solution(nextNode1, nextNode2, carry, prevNode.next);
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
