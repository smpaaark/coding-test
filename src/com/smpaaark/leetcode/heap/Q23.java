package com.smpaaark.leetcode.heap;

import java.util.PriorityQueue;

public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            while (node != null) {
                heap.offer(node);
                node = node.next;
            }
        }

        ListNode fakeHead = new ListNode();
        ListNode prevNode = fakeHead;
        while (!heap.isEmpty()) {
            prevNode.next = heap.poll();
            prevNode = prevNode.next;
        }

        prevNode.next = null;

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
