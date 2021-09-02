package com.smpaaark.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                node.left.next = node.right;
                queue.offer(node.left);
            }

            if (node.right != null) {
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                queue.offer(node.right);
            }
        }

        return root;
    }

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }

}
