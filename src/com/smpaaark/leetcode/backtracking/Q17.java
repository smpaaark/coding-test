package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q17 {

    private static final String[] NUMBER_STRING_ARRAY = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            solution(digits, result, queue);
        }

        return result;
    }

    private void solution(String digits, List<String> result, Queue<String> queue) {
        String pollStr = queue.poll();
        for (char c : NUMBER_STRING_ARRAY[digits.charAt(pollStr.length()) - '0'].toCharArray()) {
            String appendStr = pollStr + c;
            addOrOffer(digits, result, queue, appendStr);
        }
    }

    private void addOrOffer(String digits, List<String> result, Queue<String> queue, String appendStr) {
        if (appendStr.length() == digits.length()) {
            result.add(appendStr);
            return;
        }

        queue.offer(appendStr);
    }

}
