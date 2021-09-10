package com.smpaaark.leetcode.dp;

public class Q5 {

    String resultStr = "";

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            solution(s, i, i);
            solution(s, i, i + 1);
        }

        return resultStr;
    }

    private void solution(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (resultStr.length() < right - left - 1) {
            resultStr = s.substring(left + 1, right);
        }
    }

}
