package com.smpaaark.leetcode.dp;

public class Q5 {

    public String longestPalindrome(String s) {
        int sLength = s.length();
        boolean[][] dp = new boolean[sLength][sLength];
        String result = "";

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = i; j < sLength; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 2){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

}
