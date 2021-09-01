package com.smpaaark.leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q341 {

    class NestedIterator implements Iterator<Integer> {

        Stack<Integer> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            solution(nestedList);
        }

        private void solution(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                NestedInteger nestedInteger = nestedList.get(i);
                if (nestedInteger.isInteger()) {
                    stack.push(nestedInteger.getInteger());
                } else {
                    solution(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return stack.pop();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
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
