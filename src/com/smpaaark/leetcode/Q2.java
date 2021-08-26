package com.smpaaark.leetcode;

public class Q2 {

    public static void main(String[] args) {
        Q2 q = new Q2();

        ListNode l1 = new ListNode(2);
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(9);
        l1.next = node;
        node.next = node2;

        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(9);
        l2.next = node3;
        node3.next = node4;
        node4.next = node5;

        q.addTwoNumbers(l1 ,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        ListNode currentNode = fakeHead;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int sum = num1 + num2 + carry;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            currentNode.next = newNode;
            currentNode = newNode;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }

        return fakeHead.next;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
