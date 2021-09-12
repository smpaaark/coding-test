package com.smpaaark.leetcode.hashtable;

import java.util.*;

public class Q17 {

    Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Q17 q = new Q17();
        System.out.println(q.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        initMap();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty() && queue.peek().length() < digits.length()) {
            String qStr = queue.poll();
            int num = Character.getNumericValue(digits.charAt(qStr.length()));
            for (char c : map.get(num).toCharArray()) {
                queue.offer(qStr + c);
            }
        }

        return (LinkedList) queue;
    }

    private void initMap() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

}
