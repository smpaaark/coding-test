package com.smpaaark.leetcode.string;

public class Q8 {

    public static void main(String[] args) {
        Q8 q = new Q8();
        System.out.println(q.myAtoi(" "));
    }

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index >= s.length()) {
            return 0;

        }
        char c = s.charAt(index);
        int sign = 1;
        if (c == '-' || c == '+') {
            sign = c == '-' ? -1 : 1;
            index++;
        }

        long total = 0;
        long signTotal = 0;
        while (index < s.length()) {
            c = s.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }

            int num = c - '0';
            total = (total * 10) + num;
            signTotal = sign * total;

            if (signTotal < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (signTotal > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            index++;
        }

        return (int) signTotal;
    }

}
