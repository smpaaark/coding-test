package com.smpaaark.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q17 {

    final String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        Queue<String> queue = new LinkedList<>();
        if (digits.isEmpty()) {
            return (LinkedList) queue;
        }

        queue.offer("");

        while (!queue.isEmpty() && queue.peek().length() != digits.length()) {
            String qStr = queue.poll();
            String tempStr = letters[digits.charAt(qStr.length()) - '0'];
            for (char c : tempStr.toCharArray()) {
                queue.offer(qStr + c);
            }
        }

        return (LinkedList) queue;
    }

}
