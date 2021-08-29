package com.smpaaark.leetcode.bit;

public class Q29 {

    public static void main(String[] args) {
        Q29 q = new Q29();
        System.out.println(q.divide(12, 3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = 0;

        while (absDividend - absDivisor >= 0) {
            int i = 0;
            while (absDividend - (absDivisor << i << 1) >= 0) {
                i++;
            }

            result += 1 << i;
            absDividend -= absDivisor << i;
        }

        return (dividend > 0) == (divisor > 0) ? result : -result;
    }

}
