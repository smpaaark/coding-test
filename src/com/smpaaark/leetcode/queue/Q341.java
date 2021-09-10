package com.smpaaark.leetcode.queue;

import java.util.*;

public class Q341 {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);
        deque.offerFirst(0);

        System.out.println(deque);
    }

    public class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> deque = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            prepareStack(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return deque.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!deque.isEmpty() && !deque.peek().isInteger()) {
                List<NestedInteger> list = deque.pop().getList();
                prepareStack(list);
            }
            return !deque.isEmpty();
        }

        private void prepareStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                deque.offerFirst(nestedList.get(i));
            }
        }

    }

    interface NestedInteger {

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
