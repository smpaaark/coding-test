package com.smpaaark.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Q146 {

    class LRUCache {

        Map<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                add(node);
                return node.val;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                remove(node);
                add(node);
            } else {
                Node node = new Node(key, value);
                if (map.size() < capacity) {
                    map.put(key, node);
                    add(node);
                } else {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                    map.put(key, node);
                    add(node);
                }
            }
        }
    }

    class Node {

        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }

    }

}
