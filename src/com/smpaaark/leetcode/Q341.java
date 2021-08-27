package com.smpaaark.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q341 {

    static class NestedIterator implements Iterator<Integer> {

        Queue<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            flatten(nestedList);
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    flatten(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return queue.size() > 0 ? true : false;
        }

    }

    static interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }

}
