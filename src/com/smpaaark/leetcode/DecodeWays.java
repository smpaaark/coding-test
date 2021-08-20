package com.smpaaark.leetcode;

public class DecodeWays {

    int result = 0;

    public static void main(String[] args) {
        DecodeWays q = new DecodeWays();
//        System.out.println(q.numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(q.numDecodings("226"));
    }

    public int numDecodings(String s) {
        int sLength = s.length();
        int[] dp = new int[sLength + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i < dp.length; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[sLength];
    }

}
