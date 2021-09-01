package com.smpaaark.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Q138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tempNode = head;
        while (tempNode != null) {
            map.put(tempNode, new Node(tempNode.val));
            tempNode = tempNode.next;
        }

        tempNode = head;
        while (tempNode != null) {
            Node node = map.get(tempNode);
            node.next = map.get(tempNode.next);
            node.random = map.get(tempNode.random);
            tempNode = tempNode.next;
        }

        return map.get(head);
    }

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

}
