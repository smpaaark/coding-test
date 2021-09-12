package com.smpaaark.leetcode.recursion;

public class Q50 {

    public static void main(String[] args) {
        Q50 q = new Q50();
        System.out.println(q.myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }

        if (n > 0) {
            return x * temp * temp;
        } else {
            return (temp * temp) / x;
        }
    }

}
