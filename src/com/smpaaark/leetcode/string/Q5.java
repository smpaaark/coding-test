package com.smpaaark.leetcode.string;

public class Q5 {

    String result = "";

    public static void main(String[] args) {
        Q5 q = new Q5();
        System.out.println(q.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            solution(i, i, s);
            solution(i, i + 1, s);
        }

        return result;
    }

    private void solution(int startIndex, int endIndex, String s) {
        while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }

        startIndex++;
        endIndex--;
        String tempResult = s.substring(startIndex, endIndex + 1);
        if (result.length() < tempResult.length()) {
            result = tempResult;
        }
    }

}
