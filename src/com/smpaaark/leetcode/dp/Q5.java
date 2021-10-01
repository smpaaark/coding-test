package com.smpaaark.leetcode.dp;

public class Q5 {

    private int leftIndex = 0;
    private int rightIndex = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            solution(i, i, s);
            solution(i, i + 1, s);
        }

        return s.substring(leftIndex, rightIndex + 1);
    }

    private void solution(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (right - left - 2 > rightIndex - leftIndex) {
            leftIndex = left + 1;
            rightIndex = right - 1;
        }
    }

}
